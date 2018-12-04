package com.shilko.ru.labspringangular.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
