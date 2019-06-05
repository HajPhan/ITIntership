package com.example.SpingBootMongoDB.controller;

import com.example.SpingBootMongoDB.model.Employee;
import com.example.SpingBootMongoDB.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployee();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable int id) {
        return this.employeeService.getEmployeeById(id);
    }
}
