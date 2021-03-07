package com.sadman.springbootadminlte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TableController {

    @RequestMapping("pages/tables/simple")
    public String simple() {
        return "pages/tables/simple";
    }

    @RequestMapping("pages/tables/data")
    public String data() {
        return "pages/tables/data";
    }

    @RequestMapping("pages/tables/jsgrid")
    public String jsgrid() {
        return "pages/tables/jsgrid";
    }
}
