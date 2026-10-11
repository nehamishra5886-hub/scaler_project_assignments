package com.example.Evaluations.evaluation.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class InstallRequestDto {
    private UUID appId;
}
