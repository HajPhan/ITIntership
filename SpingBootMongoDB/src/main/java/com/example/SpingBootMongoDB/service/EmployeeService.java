package com.example.SpingBootMongoDB.service;

import com.example.SpingBootMongoDB.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);
    void saveEmployee(Employee employee);
    void deleteEmployeeById(int id);
}
