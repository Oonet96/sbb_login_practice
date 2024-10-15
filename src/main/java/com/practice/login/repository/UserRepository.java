package com.practice.login.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.login.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

    Optional<User> findById(int id);
    Optional<User> findByUserId(String userId);

    boolean existsByUserId(String userId);
}
