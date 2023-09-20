package com.report.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class SignupRequest {

    @Size(min = 4, max = 15, message = "Name must be minimum of 4 characters & maximum 15 characters !!!")
    private String name;

    @NotEmpty
    @Email(message = "Email Id is not valid !!!")
    private String email;

    @NotEmpty
    @Size(min = 6, max = 15, message = "Password must be minimum of 6 characters & maximum 15 characters !!!")
    @Pattern(regexp = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@%#$]).{8,20})", message = "password must be at least 6 characters & maximum 15 characters containing one Uppercase letter, one Lowercase letter, Special character and one Number")
    private String password;

    @NotEmpty
    private String role;

}
