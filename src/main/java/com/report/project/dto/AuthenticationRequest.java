package com.report.project.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;
    private String password;

}
