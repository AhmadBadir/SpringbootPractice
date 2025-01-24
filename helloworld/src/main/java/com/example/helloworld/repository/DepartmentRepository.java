package com.example.helloworld.repository;

import com.example.helloworld.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByEmployeesSizeGreaterThan(int size);
}
