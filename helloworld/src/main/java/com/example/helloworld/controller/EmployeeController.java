package com.example.helloworld.controller;

import com.example.helloworld.model.Employee;
import com.example.helloworld.service.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

  private final EmployeeServiceImpl employeeService;

  @Autowired
  public EmployeeController(EmployeeServiceImpl employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/employees")
  @Operation(summary = "Get all employees", description = "Returns a list of all employees", tags = {"Employee"})
  @ApiResponse(responseCode = "200", description = "List of employees",
          content = {@Content(mediaType = "application/json",
                  schema = @Schema(implementation = Employee.class))})
  public ResponseEntity<List<Employee>> getAllEmployees() {
    return ResponseEntity.ok(employeeService.getAllEmployees());
  }

  @GetMapping("/employees/department/{departmentId}")
  public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable Long departmentId) {
    return ResponseEntity.ok(employeeService.getEmployeesByDepartment(departmentId));
  }
}
