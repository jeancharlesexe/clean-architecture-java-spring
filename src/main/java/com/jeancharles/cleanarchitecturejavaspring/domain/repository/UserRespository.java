package com.jeancharles.cleanarchitecturejavaspring.domain.repository;

import com.jeancharles.cleanarchitecturejavaspring.domain.entity.User;

// Contract interface for User persistence
public interface UserRespository {
    User save(User user);
}
