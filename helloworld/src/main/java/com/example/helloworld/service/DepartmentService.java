package com.example.helloworld.service;


import com.example.helloworld.model.Department;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentService {

  List<Department> getDepartmentAccordingToSize(@Param("employeeCount") int employeeCount);
}
