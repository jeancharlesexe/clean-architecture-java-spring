package com.jeancharles.cleanarchitecturejavaspring.infrastructure.persistence.repository;

import com.jeancharles.cleanarchitecturejavaspring.domain.entity.User;
import com.jeancharles.cleanarchitecturejavaspring.domain.repository.UserRepository;
import com.jeancharles.cleanarchitecturejavaspring.infrastructure.persistence.jpa.entity.UserEntity;
import com.jeancharles.cleanarchitecturejavaspring.infrastructure.persistence.jpa.repository.UserRepositoryJpa;
import org.springframework.stereotype.Repository;

@Repository
public class UserRespositoryImpl implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;

    public UserRespositoryImpl(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );

        UserEntity savedEntity = userRepositoryJpa.save(userEntity);

        return User.restore(
                savedEntity.getId(),
                savedEntity.getName(),
                savedEntity.getEmail(),
                savedEntity.getPassword(),
                savedEntity.getCreatedAt(),
                savedEntity.getUpdatedAt()
        );
    }
}
