package com.example.helloworld.service;


import com.example.helloworld.model.Employee;

import java.util.List;

public interface EmployeeService {

  List<Employee> getAllEmployees();

  List<Employee> getEmployeesByDepartment(Long departmentId);
}
