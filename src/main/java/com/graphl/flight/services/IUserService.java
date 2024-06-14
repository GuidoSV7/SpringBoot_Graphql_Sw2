package com.graphl.flight.services;

import com.graphl.flight.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    User register(User user);

    User findUserById(String idUser);

    User login(String email, String password);
}
