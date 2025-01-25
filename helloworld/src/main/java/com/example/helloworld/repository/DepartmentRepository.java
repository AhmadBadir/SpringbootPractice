package com.example.helloworld.repository;

import com.example.helloworld.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

  @Query(
      "SELECT d from Department d WHERE (\n"
          + "SELECT COUNT(e) FROM Employee e WHERE e.department = d) > :size")
  List<Department> findByEmployeesSizeGreaterThan(@Param("size") int size);

  @Query("SELECT d from Department d JOIN d.employees e GROUP BY d HAVING COUNT(e) > :size")
  List<Department> findByEmployeesSizeGreaterThanUsingJoin(@Param("size") int size);
}
