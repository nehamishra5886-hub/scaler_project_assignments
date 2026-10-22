package com.example.Evaluations.evaluation.services;

import com.example.Evaluations.evaluation.dtos.UserDto;
import com.example.Evaluations.evaluation.model.User;

public interface IUserService {
    User registerNewUserAccount(UserDto userDto);
}
