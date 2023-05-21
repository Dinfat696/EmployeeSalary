package com.example.employeesalary.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer departments;
    private double salary;

    public Employee(String firstName, String lastName, Integer departments, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departments = departments;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName, double salary, Integer departments) {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDepartments() {
        return departments;
    }

    public void setDepartments(Integer departments) {
        this.departments = departments;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(departments, employee.departments);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departments=" + departments +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departments, salary);

    }
}

