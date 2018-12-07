package com.shilko.ru.labspringangular.service;

import com.shilko.ru.labspringangular.model.Users;

public interface UserService {

    void save(Users user);

    boolean exist(String username, String password);

    Users findByUsername(String username);
}
