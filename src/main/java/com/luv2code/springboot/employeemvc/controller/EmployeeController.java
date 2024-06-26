package com.luv2code.springboot.employeemvc.controller;


import com.luv2code.springboot.employeemvc.entity.Employee;
import com.luv2code.springboot.employeemvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showAddForm(Model theModel){

        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);


        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showUpdateForm(@RequestParam("employeeId") int theId , Model theModel){


        Employee theEmployee = employeeService.findById(theId);

        theModel.addAttribute("employee", theEmployee);


        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        employeeService.save(theEmployee);

        return "redirect:/employees/list";

    }

    @GetMapping("/delete")
    public String showUpdateForm(@RequestParam("employeeId") int theId){

        employeeService.deleteById(theId);
        return "redirect:/employees/list";

    }

}
