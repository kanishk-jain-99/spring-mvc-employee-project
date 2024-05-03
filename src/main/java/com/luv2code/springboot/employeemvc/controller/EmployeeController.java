package com.luv2code.springboot.employeemvc.controller;


import com.luv2code.springboot.employeemvc.entity.Employee;
import com.luv2code.springboot.employeemvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        //get employee from db

        List<Employee> theEmployees = employeeService.findAll();

        //add the result to model

        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }

}