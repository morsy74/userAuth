package com.example.mvcdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.mvcdemo.database.entity.User;
import com.example.mvcdemo.database.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private final UserRepository userRepository;
  @Autowired
  private final PasswordEncoder passwordEncoder;

  public UserService(
    UserRepository userRepository,
    PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    
  }

  public void addUser(User user) {
    String hashPass = passwordEncoder.encode(user.getPassword());
    user.setPassword(hashPass);
    user.setEnabled(true);
    user.setAccountNonExpired(true);
    user.setCredentialsNonExpired(true);
    user.setAccountNonLocked(true);
    user.setRoles(List.of("USER"));
    userRepository.save(user);
  }

  public Optional<User> findUserByUsername(String username) {
    return userRepository.findByUsername(username);
}
  
}
