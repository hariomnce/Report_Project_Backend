package com.report.project.service;

import com.report.project.dto.SignupRequest;
import com.report.project.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest) throws Exception;
}
