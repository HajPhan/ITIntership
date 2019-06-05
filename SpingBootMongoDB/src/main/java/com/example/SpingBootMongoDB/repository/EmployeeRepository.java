package com.example.SpingBootMongoDB.repository;

import com.example.SpingBootMongoDB.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository  extends MongoRepository<Employee,Integer> {
}
