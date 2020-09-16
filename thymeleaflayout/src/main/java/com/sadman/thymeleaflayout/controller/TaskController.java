package com.sadman.thymeleaflayout.controller;

import com.sadman.thymeleaflayout.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Standard Layout System with Fragment Expressions usage example
 */
@Controller
@Secured("ROLE_USER")
public class TaskController {

    @Autowired
    TaskService taskService;

    @ModelAttribute("module")
    public String module() {
        return "tasks";
    }

    @RequestMapping(value = "task", method = RequestMethod.GET)
    public String tasks(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "task/task-list";
    }

    @RequestMapping(value = "task/{id}", method = RequestMethod.GET)
    public String task(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskService.findOne(id));
        return "task/task";
    }
}
