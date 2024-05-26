package com.apica.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apica.user.entity.User;
import com.apica.user.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String USER_EVENTS_TOPIC = "user-events";

    public User registerUser(User user) {
        userRepository.save(user);
        kafkaTemplate.send(USER_EVENTS_TOPIC, "User registered: " + user.getUsername());
        return user;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        userRepository.save(user);
        kafkaTemplate.send(USER_EVENTS_TOPIC, "User updated: " + user.getUsername());
        return user;
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        userRepository.delete(user);
        kafkaTemplate.send(USER_EVENTS_TOPIC, "User deleted: " + user.getUsername());
    }
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }
}