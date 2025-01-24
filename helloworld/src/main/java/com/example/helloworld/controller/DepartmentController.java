package com.example.helloworld.controller;

import com.example.helloworld.model.Department;
import com.example.helloworld.service.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

  private final DepartmentService departmentService;

  @Autowired
  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @GetMapping("/departments/{count}")
  public ResponseEntity<List<Department>> getDepartmentByEmployeeCount(@PathVariable int count) {
    return ResponseEntity.ok(departmentService.getDepartmentAccordingToSize(count));
  }
}
