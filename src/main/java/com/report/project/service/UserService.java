package com.report.project.service;

import com.report.project.dto.SignupRequest;
import com.report.project.dto.UserDto;

public interface UserService {

    UserDto createUser(SignupRequest signupRequest) throws Exception;

    Boolean hasUserWithEnail(String email);

}
