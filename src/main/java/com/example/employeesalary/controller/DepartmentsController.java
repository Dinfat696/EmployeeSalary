package com.example.employeesalary.controller;

import com.example.employeesalary.model.Employee;
import com.example.employeesalary.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentService departmentService;

    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("min-salary")
    public Employee getMin(@RequestParam("departmenId") int department){
        return departmentService.getEmployeeWithMinSalary(department);

    }
    @GetMapping("max-salary")
    public Employee getMax(@RequestParam("departmenId")int department){
        return departmentService.getEmployeeWithMaxSalary(department);

    }
    @GetMapping(value = "/all",params = "departmenId")
    private List<Employee> getAll(@RequestParam("departmenId")int department){
        return departmentService.getEmployeeByDepartment(department);
    }
    @GetMapping(value = "/all")
    private Map<Integer,List<Employee>> getAll(){
        return departmentService.getEmployeeGrouped();
    }
}
