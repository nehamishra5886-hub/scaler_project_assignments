package com.example.Evaluations.evaluation.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
public abstract class BaseModel {
    private UUID id;
    private Date createdAt;
    private Date lastUpdatedAt;
}