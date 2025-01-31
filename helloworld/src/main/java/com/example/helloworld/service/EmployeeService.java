package com.example.helloworld.service;


import com.example.helloworld.model.Employee;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {

  List<Employee> getAllEmployees();

  List<Employee> getEmployeesByDepartment(Long departmentId);

  List<Employee> getEmployeeByIds(List<Long> ids, Sort sort);

  Employee createEmployee(String name, Long departmentId);

}
