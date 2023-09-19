package com.report.project.serviceImpl;

import com.report.project.entity.Role;
import com.report.project.repository.RoleRepository;
import com.report.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public List<Role> fetchAll() {
        return roleRepository.findAll();
    }
}
