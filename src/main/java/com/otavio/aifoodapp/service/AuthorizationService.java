package com.otavio.aifoodapp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.otavio.aifoodapp.repository.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService{

    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByLogin(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
}
    
}
