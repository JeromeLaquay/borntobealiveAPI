package com.nouhoun.springboot.jwt.integration.controller;

import com.nouhoun.springboot.jwt.integration.domain.Role;
import com.nouhoun.springboot.jwt.integration.service.UserService;
import com.nouhoun.springboot.jwt.integration.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.POST, value="/register", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
    public User create(@RequestBody User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Role role = new Role();
            role.setId(10001);
            List<Role> roles = new ArrayList<>();
            roles.add(role);
            user.setRoles(roles);
            User user2 = userService.createOrUpdate(user);
            return user2;
        }catch(Exception e){
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/users")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="/users/existing")
    public boolean existingUser(@Param("username") String username) {
        return userService.existingUsername(username);
    }

    @RequestMapping(value="/users/current", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public User currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.findByUsername(auth.getName());
    }

}
