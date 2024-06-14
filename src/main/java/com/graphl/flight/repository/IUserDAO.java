package com.graphl.flight.repository;

import com.graphl.flight.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserDAO extends MongoRepository<User, String> {
    User findByEmail(String email);
    User findUserById(String idUser);

}
