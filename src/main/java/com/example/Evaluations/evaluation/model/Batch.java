package com.example.Evaluations.evaluation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Batch {
    @Id
    private UUID id;

    @ManyToMany(mappedBy = "batches")
    private List<Instructor> instructors;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "batches_learners",
            joinColumns = @JoinColumn(name = "batch_id"),
            inverseJoinColumns = @JoinColumn(name = "learner_id")
    )
    private Set<Learner> learners = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "batches_classes",
            joinColumns = @JoinColumn(name = "batch_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private Set<Class> classes;
}
