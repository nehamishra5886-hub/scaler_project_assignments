package com.example.Evaluations.evaluation.services;

import com.example.Evaluations.evaluation.dtos.UserDto;
import com.example.Evaluations.evaluation.exceptions.UserAlreadyExistException;
import com.example.Evaluations.evaluation.model.User;
import com.example.Evaluations.evaluation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User registerNewUserAccount(UserDto userDto) {
        // TODO:
        // 1) If email already exists in repo -> throw UserAlreadyExistException with message:
        //    "There is already an account with email address: {emailvalue}"
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserAlreadyExistException(
                    "There is already an account with email address: "
                            + userDto.getEmail()
            );
        }
        // 2) Else create User:
        //    - firstName, lastName, email from dto
        //    - password must be encoded using BCryptPasswordEncoder
        //    - roles must contain "ROLE_USER"
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        user.setRoles(Arrays.asList("ROLE_USER"));
        // 3) Save user via userRepository.save(user) and return saved user
        return userRepository.save(user);
        //return null; // remove this

    }
}
