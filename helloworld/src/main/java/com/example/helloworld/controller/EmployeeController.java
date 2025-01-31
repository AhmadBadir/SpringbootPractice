package com.example.helloworld.controller;

import com.example.helloworld.model.Employee;
import com.example.helloworld.service.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false) List<Long> ids,
                                                        @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                        @RequestParam(required = false, defaultValue = "ASC") String direction) {
    Sort.Direction sortDirection = Sort.Direction.fromString(direction);
    Sort sort = Sort.by(sortDirection, sortBy);
    return ResponseEntity.ok(employeeService.getEmployeeByIds(ids, sort));
  }


  //return using post, also  I am not using response entity here for proof of concept
  @PostMapping("/employees")
  public List<Employee> getAllEmployeesUsingPost(@RequestBody(required = false) List<Long> ids,
                                                 @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                 @RequestParam(required = false, defaultValue = "ASC") String direction) {
    Sort.Direction sortDirection = Sort.Direction.fromString(direction);
    Sort sort = Sort.by(sortDirection, sortBy);
    return employeeService.getEmployeeByIds(ids, sort);
  }

  //return using post, also  I am not using response entity here for proof of concept
  @PostMapping("/employees")
  @ResponseStatus(HttpStatus.CREATED)
  public Employee createEmployee(@RequestParam(required = true) String name,
                                 @RequestParam(required = true, defaultValue = "id") Long departmentId) {
    return employeeService.createEmployee(name, departmentId);
  }


  @GetMapping("/employees/department/{departmentId}")
  public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable Long departmentId) {
    return ResponseEntity.ok(employeeService.getEmployeesByDepartment(departmentId));
  }
}
