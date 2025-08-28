package com.jeancharles.cleanarchitecturejavaspring.application.core.user.service;

import com.jeancharles.cleanarchitecturejavaspring.application.core.user.port.input.CreateUserCommand;
import com.jeancharles.cleanarchitecturejavaspring.application.core.user.port.input.CreateUserInteractor;
import com.jeancharles.cleanarchitecturejavaspring.application.core.user.port.input.CreateUserResponse;
import com.jeancharles.cleanarchitecturejavaspring.domain.entity.User;
import com.jeancharles.cleanarchitecturejavaspring.domain.exception.UserAlreadyExistsException;
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
        if(userRepository.existsByEmail(command.getEmail())){
            throw new UserAlreadyExistsException(command.getEmail());
        }
        // -------------

        // 2 creating domain entity using factory method
        User user = User.create(command.getName(), command.getEmail(), command.getPassword());

        // 3 saving the output of gateway
        User savedUser = userRepository.save(user);

        // 4 returning the response
        return new CreateUserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getCreatedAt()
        );

    }
}
