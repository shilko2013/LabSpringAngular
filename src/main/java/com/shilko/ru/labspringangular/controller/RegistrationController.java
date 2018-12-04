package com.shilko.ru.labspringangular.controller;

import com.shilko.ru.labspringangular.model.Users;
import com.shilko.ru.labspringangular.service.SecurityService;
import com.shilko.ru.labspringangular.service.UserService;
import com.shilko.ru.labspringangular.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity registration(@RequestParam("username") String username,
                                @RequestParam("password") String password) {
        Users user = new Users(username, password);

        String errorMessage = userValidator.validate(user);

        if (!errorMessage.equals("success"))
            return ResponseEntity.badRequest().body(errorMessage);

        userService.save(user);

        //securityService.autoLogin(user.getUsername(), user.getPassword());

        return ResponseEntity.ok("Registration success");
    }
}
