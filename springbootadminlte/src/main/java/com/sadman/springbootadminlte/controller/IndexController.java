package com.sadman.springbootadminlte.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sanjay on 8/15/2016.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
