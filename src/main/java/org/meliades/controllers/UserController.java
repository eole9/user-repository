package org.meliades.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Fred on 20/04/2015.
 *
 * @author Fred
 */
@RestController
public class UserController {

    @RequestMapping("/")
    public String hello() {
        return "Hello";
    }
}
