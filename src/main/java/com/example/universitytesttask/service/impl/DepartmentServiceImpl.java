package com.example.universitytesttask.service.impl;

import com.example.universitytesttask.exception.UniversityEntityNotFound;
import com.example.universitytesttask.model.Degree;
import com.example.universitytesttask.model.Department;
import com.example.universitytesttask.model.Lector;
import com.example.universitytesttask.repository.DepartmentRepository;
import com.example.universitytesttask.service.DepartmentService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name)
                .orElseThrow(() -> new UniversityEntityNotFound(name));
    }

    @Override
    public Map<Degree, Long> getDepartmentStatisticsMap(String name) {
        Department department = getDepartmentByName(name);
        return department.getLectors().stream()
                .collect(Collectors.groupingBy(Lector::getDegree, Collectors.counting()));
    }

    @Override
    public BigDecimal getAverageSalaryForDepartment(String name) {
        Set<Lector> lectors = getLectorsByDepartmentName(name);

        if (lectors.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalSalary = lectors.stream()
                .map(Lector::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalSalary.divide(BigDecimal.valueOf(lectors.size()), RoundingMode.HALF_UP);
    }

    @Override
    public int countEmployeesByDepartment(String name) {
        return getLectorsByDepartmentName(name).size();
    }

    @Override
    public List<Department> getDepartmentsContainingQuery(String query) {
        return departmentRepository.findAllByNameContainingIgnoreCase(query);
    }

    private Set<Lector> getLectorsByDepartmentName(String name) {
        Department department = getDepartmentByName(name);
        return department.getLectors();
    }
}
