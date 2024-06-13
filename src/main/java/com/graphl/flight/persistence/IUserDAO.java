package com.graphl.flight.persistence;

import com.graphl.flight.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserDAO extends MongoRepository<User, String> {
    User findByEmail(String email);

}
