package com.report.project.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private String message;
    private boolean success;

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
