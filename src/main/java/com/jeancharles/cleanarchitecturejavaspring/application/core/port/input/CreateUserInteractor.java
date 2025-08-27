package com.jeancharles.cleanarchitecturejavaspring.application.core.port.input;

// open port to use case (entry)
public interface CreateUserInteractor {
    // high layer (controller from infra) call this use case
    // pass the command (an example of entry)
    // and wait for this interactor give the response
    CreateUserResponse execute(CreateUserCommand command);
}
