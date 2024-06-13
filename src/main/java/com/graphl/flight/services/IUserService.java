package com.graphl.flight.services;

import com.graphl.flight.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    User register(User user);
    User login(String email, String password);
}
