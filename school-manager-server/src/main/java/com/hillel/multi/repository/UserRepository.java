package com.hillel.multi.repository;

import java.util.Optional;

import com.hillel.multi.persistent.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
