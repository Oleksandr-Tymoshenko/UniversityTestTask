package com.example.universitytesttask.repository;

import com.example.universitytesttask.model.Department;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @EntityGraph(attributePaths = {"lectors", "head"})
    Optional<Department> findByName(String name);

    List<Department> findAllByNameContainingIgnoreCase(String query);
}
