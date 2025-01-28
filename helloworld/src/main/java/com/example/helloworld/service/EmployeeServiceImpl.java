package com.example.helloworld.service;

import com.example.helloworld.model.Employee;
import com.example.helloworld.repository.DepartmentRepository;
import com.example.helloworld.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public List<Employee> getEmployeesByDepartment(Long departmentId) {
    return employeeRepository.findByDepartmentId(departmentId);
  }

  @Override
  public List<Employee> getEmployeeByIds(List<Long> ids) {
   return (ids == null || ids.isEmpty())? getAllEmployees() : employeeRepository.finByIds(ids);
  }
}

