package com.example.SpingBootMongoDB.controller;

import com.example.SpingBootMongoDB.model.Employee;
import com.example.SpingBootMongoDB.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
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

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String saveEmployee() {
        double n = 1;
        Employee employee = new Employee("Phan Van MongoDB", "male", new Date(), "Ha Noi", "+84988680636");
        Long start = System.currentTimeMillis();
        while (n <= 1000000) {
            this.employeeService.saveEmployee(employee);
            ++n;
        }
        Long stop = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        String total_time = formatter.format((stop - start) / 1000);
        return total_time;
    }
}
