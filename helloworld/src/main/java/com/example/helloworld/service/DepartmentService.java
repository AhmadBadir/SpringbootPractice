package com.example.helloworld.service;


import com.example.helloworld.model.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentService {

  List<Department> getDepartmentAccordingToSize(int employeeCount);

  List<Department> getDepartmentAccordingToSizeByJoin(int employeeCount);

}
