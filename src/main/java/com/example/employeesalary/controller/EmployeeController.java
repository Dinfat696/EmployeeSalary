package com.example.employeesalary.controller;

import com.example.employeesalary.model.Employee;
import com.example.employeesalary.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public Collection <Employee> all(){
        return employeeService.getAll();
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,@RequestParam String lastName, @RequestParam double salary, @RequestParam Integer departments) {
        return employeeService.add(new Employee(firstName, lastName, salary, departments));
    }

    @GetMapping("/remove")
    public Employee remove( String firstName, String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,@RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

}
