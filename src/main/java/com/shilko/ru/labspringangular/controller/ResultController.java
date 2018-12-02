package com.shilko.ru.labspringangular.controller;

import com.google.gson.Gson;
import com.shilko.ru.labspringangular.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity getAllResults() {
        return ResponseEntity.ok(new Gson().toJson(resultService.getAllResults()));
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity addResult(@RequestParam("x") double x,
                             @RequestParam("y") double y,
                             @RequestParam("r") double r) {
        return ResponseEntity.ok("{\"checking\": \"" + resultService.addResult(x, y, r) + "\"}");
    }

    @RequestMapping(value = "/disablesession", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity disableSession() {
        resultService.disableSession();
        return ResponseEntity.ok().body("Session was disabled");
    }
}
