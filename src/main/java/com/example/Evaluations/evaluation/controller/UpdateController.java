package com.example.Evaluations.evaluation.controller;

import com.example.Evaluations.evaluation.dtos.CheckUpdateResponseDto;
import com.example.Evaluations.evaluation.dtos.InstallResponseDto;
import com.example.Evaluations.evaluation.dtos.UpdateRequestDto;
import com.example.Evaluations.evaluation.dtos.UpdateResponseDto;
import com.example.Evaluations.evaluation.model.CheckUpdateStatus;
import com.example.Evaluations.evaluation.model.UpdateStatus;
import com.example.Evaluations.evaluation.model.Version;
import com.example.Evaluations.evaluation.services.IDeployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/update")
public class UpdateController {

    @Autowired
    private IDeployService deployService;

    //Implement your API here

    public UpdateResponseDto updateApp(@RequestBody UpdateRequestDto requestDto) {

        if(requestDto.getAppId() == null) {
            throw new IllegalArgumentException("Either AppId or version is missing");
        }
        UpdateStatus status = deployService.update(requestDto.getAppId(), requestDto.getVersion());

        UpdateResponseDto responseDto = new UpdateResponseDto();
        responseDto.setAppId(requestDto.getAppId());
        responseDto.setStatus(status);
        return responseDto;
    }

    @GetMapping("/{id}/installedVersion/{version}")
    public CheckUpdateResponseDto checkUpdate(@PathVariable UUID id, @PathVariable String version) {
        Version latestVersion = deployService.getLatestVersion(id, version);
        CheckUpdateResponseDto responseDto = new CheckUpdateResponseDto();
        responseDto.setAppId(id);

        if(latestVersion == null) {
            responseDto.setStatus(CheckUpdateStatus.NO_UPDATE);
            responseDto.setAppId(id);
        } else {
            responseDto.setStatus(CheckUpdateStatus.UPDATE_AVAILABLE);
            responseDto.setVersion(latestVersion);
        }


        return responseDto;
    }
}
