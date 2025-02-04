package com.example.helloworld.service;

import com.example.helloworld.model.Department;
import com.example.helloworld.model.Employee;
import com.example.helloworld.repository.DepartmentRepository;
import com.example.helloworld.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final DepartmentRepository departmentRepository;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
    this.employeeRepository = employeeRepository;
    this.departmentRepository = departmentRepository;
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
  public List<Employee> getEmployeeByIds(List<Long> ids, Sort sort) {
   return (ids == null || ids.isEmpty())? getAllEmployees() : employeeRepository.finByIds(ids, sort);
  }

  @Override
  public Employee createEmployee(String name, Long departmentId) {
    Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new IllegalArgumentException("Department not found with id: " + departmentId));
    Employee employee = new Employee(name, department);
    return employeeRepository.save(employee);
  }
}

