package com.example.Evaluations.evaluation.dtos;

import com.example.Evaluations.evaluation.model.UpdateStatus;
import com.example.Evaluations.evaluation.model.Version;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
public class UpdateResponseDto {
    private UpdateStatus status;
    private Version version;
    private UUID appId;
}
