package com.report.project.service;

import com.report.project.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    Role saveRole(Role role);

    List<Role> fetchAll();
}
