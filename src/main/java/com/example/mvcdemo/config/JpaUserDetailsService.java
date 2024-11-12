package com.example.mvcdemo.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mvcdemo.database.repository.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {
  private final  UserRepository userRepository;

  public JpaUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository
      .findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
  }
}
