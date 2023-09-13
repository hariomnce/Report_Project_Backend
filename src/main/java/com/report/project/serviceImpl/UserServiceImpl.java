package com.report.project.serviceImpl;

import com.report.project.dto.SignupRequest;
import com.report.project.dto.UserDto;
import com.report.project.entity.User;
import com.report.project.repository.UserRepository;
import com.report.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(SignupRequest signupRequest) throws Exception {
        User user = new User(signupRequest.getEmail(), new BCryptPasswordEncoder().encode(signupRequest.getPassword()), signupRequest.getName());
        user =userRepository.saveAndFlush(user);
        if (user==null) {
            return null;
        }
        return user.mapUsertoUserDto();
    }

    @Override
    public Boolean hasUserWithEnail(String email) {
        return userRepository.findFirstByEmail(email)!=null;
    }
}
