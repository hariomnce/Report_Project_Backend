package com.report.project.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NotEmpty(message = "Enter valid username")
    private String email;

    @NotEmpty(message = "you entered wrong password")
    private String password;

}
