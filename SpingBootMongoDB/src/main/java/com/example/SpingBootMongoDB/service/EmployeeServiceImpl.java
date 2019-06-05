package com.example.SpingBootMongoDB.service;

import com.example.SpingBootMongoDB.model.Employee;
import com.example.SpingBootMongoDB.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return this.employeeRepository.findById(id).get();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        this.employeeRepository.deleteById(id);
    }

}
