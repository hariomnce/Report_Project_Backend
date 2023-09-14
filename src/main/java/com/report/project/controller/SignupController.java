package com.report.project.controller;

import com.report.project.dto.SignupRequest;
import com.report.project.dto.UserDto;
import com.report.project.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@Valid @RequestBody SignupRequest signupRequest) throws Exception {
        UserDto createdUser = authService.createUser(signupRequest);
        if (createdUser == null) {
            return new ResponseEntity<>("User not created, come again later !!! ", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
