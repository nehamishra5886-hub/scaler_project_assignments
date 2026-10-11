package com.example.Evaluations.evaluation.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateRequestDto {
    private UUID appId;
    private String version;
}
