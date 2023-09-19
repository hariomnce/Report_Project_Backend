package com.report.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "employee Name can't be empty")
    private String employeeName;

    @NotEmpty(message = "Project Name can't be empty")
    private String projectName;

    //@NotNull(message = "Date is Mandatory")
    private LocalDateTime date;

    @NotNull(message = "Worked hours should not be null")
    @DecimalMin(value = "0.0", message = "Worked hours should be greater than or equal to 0")
    private Float hoursWorked;

    @NotEmpty(message = "Comment can't be empty")
    private String comments;

}
