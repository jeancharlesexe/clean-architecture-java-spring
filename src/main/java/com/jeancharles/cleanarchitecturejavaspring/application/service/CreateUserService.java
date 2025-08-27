package com.jeancharles.cleanarchitecturejavaspring.application.service;

import com.jeancharles.cleanarchitecturejavaspring.application.port.input.CreateUserCommand;
import com.jeancharles.cleanarchitecturejavaspring.application.port.input.CreateUserInteractor;
import com.jeancharles.cleanarchitecturejavaspring.application.port.input.CreateUserResponse;
import com.jeancharles.cleanarchitecturejavaspring.domain.entity.User;
import com.jeancharles.cleanarchitecturejavaspring.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

// injecting service spring dependencies
@Service
public class CreateUserService implements CreateUserInteractor {
    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponse execute(CreateUserCommand command){
        // 1 validations

        // -------------

        // 2 creating domain entity using factory method
        User user = User.create(command.getName(), command.getEmail(), command.getPassword());

        // 3 saving the output of gateway
        User savedUser = userRepository.save(user);

        // 4 returning the response
        return new CreateUserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getName(),
                savedUser.getCreatedAt()
        );

    }
}
