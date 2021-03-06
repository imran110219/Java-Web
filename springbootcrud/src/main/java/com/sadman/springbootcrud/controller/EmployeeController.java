package com.sadman.springbootcrud.controller;

import com.sadman.springbootcrud.exception.RecordNotFoundException;
import com.sadman.springbootcrud.model.Employee;
import com.sadman.springbootcrud.model.Image;
import com.sadman.springbootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @RequestMapping
    public String getAllEmployees(Model model)
    {
        List<Employee> list = service.getAllEmployees();

        model.addAttribute("employees", list);
        return "list-employees";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotFoundException
    {
        if (id.isPresent()) {
            Employee entity = service.getEmployeeById(id.get());
            model.addAttribute("employee", entity);
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "add-edit-employee";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        service.deleteEmployeeById(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
    public String createOrUpdateEmployee(Employee employee)
    {
        service.createOrUpdateEmployee(employee);
        return "redirect:/";
    }

    @PostMapping("/fileupload")
    public String fileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
        try {
            byte[] image = file.getBytes();
            Image model = new Image(name, image);
            int saveImage = service.saveImage(model);
            if (saveImage == 1) {
                return "success";
            } else {
                return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }
}
