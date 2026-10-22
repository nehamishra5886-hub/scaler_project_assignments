package com.example.Evaluations.evaluation.services;

import com.example.Evaluations.evaluation.dtos.LoginRequestDto;
import com.example.Evaluations.evaluation.dtos.UserDto;
import com.example.Evaluations.evaluation.exceptions.PasswordMismatchException;
import com.example.Evaluations.evaluation.exceptions.UserAlreadyExistException;
import com.example.Evaluations.evaluation.exceptions.UserNotFoundException;
import com.example.Evaluations.evaluation.model.User;
import com.example.Evaluations.evaluation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.RandomStringUtils;

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

    @Override
    public String login(LoginRequestDto loginRequestDto) throws UserNotFoundException, PasswordMismatchException {
        // TODO:
        // If user is not found, throw UserNotFoundException with message:
        // "There is no account with an email address: {emailvalue}"
        //
        String email = loginRequestDto.getEmail();

        if (!userRepository.existsByEmail(email)) {
            throw new UserNotFoundException(
                    "There is no account with an email address: " + email
            );
        }

        // If user has passed wrong password, throw PasswordMismatchException with message:
        // "Please type correct password, or reset it"
        // Check password using BCryptPasswordEncoder.matches()
        //
        User user = userRepository.findByEmail(email);

        if (!passwordEncoder.matches(
                loginRequestDto.getPassword(),
                user.getPassword())) {
            throw new PasswordMismatchException(
                    "Please type correct password, or reset it"
            );
        }
        // Otherwise generate a random alphanumeric token of length 15 using RandomStringUtils

        return RandomStringUtils.randomAlphanumeric(15);

        //return null;
    }
}
