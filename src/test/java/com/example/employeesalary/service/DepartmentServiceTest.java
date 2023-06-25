package com.example.employeesalary.service;

import com.example.employeesalary.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentService departmentService;

    List<Employee> employees = Arrays.asList(
            new Employee("Ivan", "Ivanov", 1, 10000),
            new Employee("Petr", "Petrov", 1, 20000),
            new Employee("Masha", "Ivanova", 2, 30000),
            new Employee("Dasha", "Petrova", 2, 40000)


    );

    @BeforeEach
    void setup() {
        when(employeeService.getAll()).thenReturn(employees);
    }

    @Test
    void max() {
        int actual = departmentService.getEmployeeWithMaxSalary(2).getDepartment();
        assertEquals(2,actual);
    }
    @Test
    void min() {
        int actual = departmentService.getEmployeeWithMinSalary(1).getDepartment();
        assertEquals(1,actual);
    }
    @Test
    void getAllByDepartment(){
        List<Employee> actual=departmentService.getEmployeeByDepartment(2);
        List<Employee> expected=Arrays.asList(
                new Employee("Masha", "Ivanova",2,30000),
                new Employee("Dasha", "Petrova",2,30000)
                );
        assertEquals(expected.size(),actual.size());
        assertFalse(expected.containsAll(actual));

    }
@Test
    void getAll(){
        List<Integer> excpetedDepartments=employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        Map<Integer,List<Employee>> actual=departmentService.getEmployeeGrouped();
        assertEquals(excpetedDepartments.size(),actual.keySet().size());
        assertTrue(excpetedDepartments.containsAll(actual.keySet()));

    }
}



