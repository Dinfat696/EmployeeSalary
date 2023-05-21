package com.example.employeesalary.service;

import com.example.employeesalary.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalary(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartments() == department)
                .max(Comparator.comparingDouble(u -> u.getSalary()))
                .orElse(null);
    }

    public Employee getEmployeeWithMinSalary(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartments() == department)
                .min(Comparator.comparingDouble(u -> u.getSalary()))
                .orElse(null);
    }



    public List<Employee> getEmployeeByDepartment(int department){
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartments() == department)
                .collect(Collectors.toList());

    }
    public Map<Integer,List<Employee>> getEmployeeGrouped(){
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartments));

    }
}

