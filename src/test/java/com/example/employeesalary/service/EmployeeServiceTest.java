package com.example.employeesalary.service;

import com.example.employeesalary.exception.EmployeeAlReadyAddedException;
import com.example.employeesalary.exception.EmployeeNotFoundException;
import com.example.employeesalary.exception.EmployeeStorageIsFullException;
import com.example.employeesalary.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();

    @Test
    void getAll() {
        Employee e1 = new Employee("Ivan", "Ivanov", 1, 10000);
        Employee e2 = new Employee("Petr", "Pentov", 1, 10000);
        employeeService.add(e1);
        employeeService.add(e2);

        List<Employee> expected = Arrays.asList(e1, e2);

        Assertions.assertIterableEquals(expected, employeeService.getAll());
        Assertions.assertEquals(2, employeeService.getAll().size());
    }

    @Test
    void add() {
        int prevSize = employeeService.getAll().size();
        Employee e1 = new Employee("Ivan", "Ivanov", 1, 10000);
        employeeService.add(e1);

        Assertions.assertEquals(prevSize + 1, employeeService.getAll().size());
        Assertions.assertTrue(employeeService.getAll().contains(e1));

    }

    @Test
    void whenAddDublicateThenThrowException() {
        Employee e1 = new Employee("Ivan", "Ivanov", 1, 10000);
        Assertions.assertDoesNotThrow(() -> employeeService.add(e1));
        Assertions.assertThrows(EmployeeAlReadyAddedException.class, () -> employeeService.add(e1));
    }

    @Test
    void whenAStorageIsFullThenThrowException() {
        Employee e1 = new Employee("John", "Doe", 2, 100);
        Employee e2 = new Employee("Jane", "Smith", 2, 200);
        Employee e3 = new Employee("Michael", "Johnson", 1, 150);
        Employee e4 = new Employee("Emily", "Brown", 1, 250);
        Employee e5 = new Employee("David", "Wilson", 1, 350);

        employeeService.add(e1);
        employeeService.add(e2);
        employeeService.add(e3);
        employeeService.add(e4);
        employeeService.add(e5);

        Employee e6 = new Employee("Sarah", "Davis", 2, 340);

        Assertions.assertThrows(EmployeeStorageIsFullException.class, () -> {
            employeeService.add(e6);
        });

    }

    @Test
    void findPositive() {
        Employee expected = new Employee("Ivan", "Ivanov", 1, 10000);
        employeeService.add(expected);
        Employee actual = employeeService.find("Ivan", "Ivanov");
        assertNotNull(actual);
        assertEquals(expected, actual);

    }

    @Test
    void findNegative() {
        Employee expected = new Employee("Ivan", "Ivanov", 1, 10000);
        employeeService.add(expected);
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find("dasha", "pupkina"));
    }

    @Test
    void remove() {
        Employee e = new Employee("Ivan", "Ivanov", 1, 10000);
        employeeService.add(e);
        assertTrue(employeeService.getAll().contains(e));
        employeeService.remove("Ivan", "Ivanov");
        assertFalse(employeeService.getAll().contains(e));


    }
}
