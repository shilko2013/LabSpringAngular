package com.shilko.ru.labspringangular.controller;

import com.shilko.ru.labspringangular.model.Users;
import com.shilko.ru.labspringangular.service.UserService;
import com.shilko.ru.labspringangular.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
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

        return ResponseEntity.ok("Registration success");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if (!userService.exist(username,password))
            return ResponseEntity.badRequest().body("Authentication failed");
        else
            return ResponseEntity.ok("Authentication success");
    }
}
