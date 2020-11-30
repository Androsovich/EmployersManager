package ru.mail.dekster.igor.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(@RequestParam(name = "hidden") String message) {
        log.info(message);
        return "login";
    }
}