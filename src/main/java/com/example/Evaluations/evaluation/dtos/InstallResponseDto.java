package com.example.Evaluations.evaluation.dtos;

import com.example.Evaluations.evaluation.model.InstallStatus;
import com.example.Evaluations.evaluation.model.Version;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class InstallResponseDto {
    private InstallStatus status;
    private final Version version = new Version();
    private UUID appId;
}
