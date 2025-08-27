package com.jeancharles.cleanarchitecturejavaspring.application.port.input;

// Command - an example of data entry to interactor use
public class CreateUserCommand{
    private final String name;
    private final String email;
    private final String password;

    public CreateUserCommand(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
