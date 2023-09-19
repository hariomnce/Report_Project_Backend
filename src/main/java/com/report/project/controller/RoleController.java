package com.report.project.controller;

import com.report.project.entity.Role;
import com.report.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/saveRole")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        roleService.saveRole(role);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }

    @GetMapping("/role/getRole")
    public List<Role>get(){
        return roleService.fetchAll();
    }
}
