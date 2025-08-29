package com.jeancharles.cleanarchitecturejavaspring.core.application.user.service;

import com.jeancharles.cleanarchitecturejavaspring.core.application.user.port.input.CreateUserCommand;
import com.jeancharles.cleanarchitecturejavaspring.core.application.user.port.CreateUserUseCase;
import com.jeancharles.cleanarchitecturejavaspring.core.application.user.port.output.CreateUserResponse;
import com.jeancharles.cleanarchitecturejavaspring.core.domain.entity.User;
import com.jeancharles.cleanarchitecturejavaspring.core.domain.exception.UserAlreadyExistsException;
import com.jeancharles.cleanarchitecturejavaspring.core.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

// injecting service spring dependencies
@Service
public class CreateUserService implements CreateUserUseCase {
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
