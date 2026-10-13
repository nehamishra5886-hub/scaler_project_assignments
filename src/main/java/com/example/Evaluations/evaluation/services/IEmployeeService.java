package com.example.Evaluations.evaluation.services;

import com.example.Evaluations.evaluation.model.Permission;

import java.util.List;

public interface IEmployeeService {
    List<Permission> getPermissionsBasedOnRoles(List<String> roleList);

    Boolean isOnboarded(Long id,String email);

    Boolean isIdentityProvided(String email, String password, String name);
}
