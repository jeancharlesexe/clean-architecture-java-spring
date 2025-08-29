package com.jeancharles.cleanarchitecturejavaspring.core.application.user.port;

import com.jeancharles.cleanarchitecturejavaspring.core.application.user.port.input.CreateUserCommand;
import com.jeancharles.cleanarchitecturejavaspring.core.application.user.port.output.CreateUserResponse;

// open port to use case (entry)
public interface CreateUserUseCase {
    // high layer (controller from infra) call this use case
    // pass the command (an example of entry)
    // and wait for this interactor give the response
    CreateUserResponse execute(CreateUserCommand command);
}
