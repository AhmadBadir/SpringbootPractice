package com.example.helloworld.cmd;

import com.example.helloworld.model.Department;
import com.example.helloworld.model.Employee;
import com.example.helloworld.repository.DepartmentRepository;
import com.example.helloworld.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        if (departmentRepository.count() == 0) { // Check if departments exist
            initializeDepartments();
        }

        if (employeeRepository.count() == 0) { // Check if employees exist
            initializeEmployees();
        }
    }

    private void initializeDepartments() {
        departmentRepository.save(new Department("HR"));
        departmentRepository.save(new Department("IT"));
        departmentRepository.save(new Department("Finance"));
        departmentRepository.save(new Department("Marketing"));
        departmentRepository.save(new Department("Operations"));
        departmentRepository.save(new Department("Sales"));
        departmentRepository.save(new Department("R&D"));
    }

    private void initializeEmployees() {
        List<Department> departments = departmentRepository.findAll();
        int[] distribution = {150, 300, 225, 150, 300, 225, 150};
        List<Employee> employees = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < departments.size(); i++) {
            for (int j = 0; j < distribution[i]; j++) {
                employees.add(new Employee("Employee_" + (j + 1) + "_Dept_" + departments.get(i).getName(), departments.get(i)));
            }
        }
        java.util.Collections.shuffle(employees, rand);
        employeeRepository.saveAll(employees);

        System.out.println("Data loaded: " + employees.size() + " employees across " + departments.size() + " departments.");
    }
}