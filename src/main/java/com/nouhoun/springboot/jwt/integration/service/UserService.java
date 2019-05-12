package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User createOrUpdate(User user) {
        return userRepository.saveAndFlush(user);
    }

    public boolean existingUsername(String username){
            User user = userRepository.findByUsername(username);
            if(user != null && user.getUsername() != null && user.getUsername() != ""){
                return true;
            }
        return false;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
