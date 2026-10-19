package com.example.Evaluations.evaluation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Class {
    @Id
    private UUID id;

    private String topic;

    @ManyToMany(mappedBy = "classes")
    private Set<Batch> batches;

    @ManyToOne
    @JoinColumn(name = "current_instructor_id")
    private Instructor currentInstructor;
}
