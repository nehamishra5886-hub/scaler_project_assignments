package com.example.Evaluations.evaluation.dtos;

import com.example.Evaluations.evaluation.model.CheckUpdateStatus;
import com.example.Evaluations.evaluation.model.Version;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Setter
@Getter
public class CheckUpdateResponseDto {
    private UUID appId;
    private CheckUpdateStatus status;
    private Version version;
}
