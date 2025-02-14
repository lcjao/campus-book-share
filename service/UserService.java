package com.example.campusbookshare.service;

import model.User;
import com.example.campusbookshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        user.setCreated_at(new Date());
        return userRepository.save(user);
    }
}