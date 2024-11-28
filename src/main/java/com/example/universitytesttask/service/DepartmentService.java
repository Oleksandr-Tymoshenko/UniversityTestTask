package com.example.universitytesttask.service;

import com.example.universitytesttask.model.Degree;
import com.example.universitytesttask.model.Department;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Department getDepartmentByName(String name);

    Map<Degree, Long> getDepartmentStatisticsMap(String name);

    BigDecimal getAverageSalaryForDepartment(String name);

    int countEmployeesByDepartment(String name);

    List<Department> getDepartmentsContainingQuery(String query);
}
