package com.sparco.backend.controller;

import com.sparco.backend.Repository.UserRepository;
import com.sparco.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User register (@RequestBody User user){
        return userRepository.save(user);
    }

    @PostMapping
    public User login (@RequestBody User user){
        return userRepository.findByEmailAndPassword(user.getEmail(), user.getPass());
    }
}
