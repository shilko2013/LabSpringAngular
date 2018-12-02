package com.shilko.ru.labspringangular.controller;

import com.google.gson.Gson;
import com.shilko.ru.labspringangular.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.util.Pair;
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
    ResponseEntity addResult(@RequestParam("x") String strX,
                             @RequestParam("y") String strY,
                             @RequestParam("r") String strR) {
        Pair<Boolean, Boolean> result = resultService.addResult(strX, strY, strR);
        if (result.getFirst())
            return ResponseEntity.ok("{\"checking\": \"" + result.getSecond() + "\"}");
        else
            return ResponseEntity.badRequest().body("Illegal set of arguments");
    }

    @RequestMapping(value = "/disablesession", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity disableSession() {
        resultService.disableSession();
        return ResponseEntity.ok().body("Session was disabled");
    }
}
