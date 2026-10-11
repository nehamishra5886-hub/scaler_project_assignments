package com.example.Evaluations.evaluation.controller;


import com.example.Evaluations.evaluation.dtos.InstallResponseDto;
import com.example.Evaluations.evaluation.model.InstallStatus;
import com.example.Evaluations.evaluation.services.IDeployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/install")
public class InstallController {

    @Autowired
    private IDeployService deployService;

    //Implement your API here

    @PostMapping
    public InstallResponseDto install(@RequestBody InstallResponseDto request) {
        if(request.getAppId() == null) {
            throw new IllegalArgumentException("AppId is null");
        }
        InstallStatus status = deployService.install(request.getAppId());

        InstallResponseDto responseDto = new InstallResponseDto();
        responseDto.setAppId(request.getAppId());
        responseDto.setStatus(status);
        return responseDto;

    }

}
