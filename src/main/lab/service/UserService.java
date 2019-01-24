package main.lab.service;

import main.lab.model.Users;

public interface UserService {
    void save(Users user);

    boolean exist(String username, String password);

    Users findByUsername(String username);
}
