package com.report.project.serviceImpl;

import com.report.project.dto.SignupRequest;
import com.report.project.dto.UserDto;
import com.report.project.entity.User;
import com.report.project.repository.UserRepository;
import com.report.project.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(SignupRequest signupRequest) throws Exception {
        User user=new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(signupRequest.getRole());
        User createdUser=userRepository.saveAndFlush(user);

        UserDto userDto=new UserDto();
        userDto.setId(createdUser.getId());
        userDto.setEmail(createdUser.getEmail());
        userDto.setName(createdUser.getName());
        userDto.setRole(createdUser.getRole());
        return userDto;
    }

    @Override
    public int getUserCount() {
        return userRepository.findByUserCount();
    }
}
