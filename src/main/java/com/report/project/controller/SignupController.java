package com.report.project.controller;

import com.report.project.dto.SignupRequest;
import com.report.project.dto.UserDto;
import com.report.project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    UserService userService;

    public ResponseEntity<?> signupUser(@Valid @RequestBody SignupRequest signupRequest) throws Exception {
        if (userService.hasUserWithEnail(signupRequest.getEmail()))
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);

        UserDto createdUser = userService.createUser(signupRequest);
        if (createdUser == null)
            return new ResponseEntity<>("User not created, come again later", HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
}
