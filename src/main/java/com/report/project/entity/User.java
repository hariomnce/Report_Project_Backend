package com.report.project.entity;

import com.report.project.dto.UserDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true, length = 20)
    @Email(message = "Email Id is not valid !!!")
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    @Size(min = 4, max = 15, message = "Name must be minimum of 4 characters & maximum 15 characters !!!")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "role", nullable = false, unique = true)
    private String role;

//    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_roles",
//            joinColumns =
//            @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"))
//    private List<Role> roles;
//
//    private String roleName;

}
