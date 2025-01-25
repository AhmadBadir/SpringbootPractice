package com.example.helloworld.service;

import com.example.helloworld.model.Department;
import com.example.helloworld.repository.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  @Autowired
  public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }


  @Override
  public List<Department> getDepartmentAccordingToSize(int employeeCount) {
    return departmentRepository.findByEmployeesSizeGreaterThan(employeeCount);
  }

  @Override
  public List<Department> getDepartmentAccordingToSizeByJoin(int employeeCount) {
    return departmentRepository.findByEmployeesSizeGreaterThanUsingJoin(employeeCount);
  }
}

