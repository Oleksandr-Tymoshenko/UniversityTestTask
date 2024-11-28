package com.example.universitytesttask.command.impl;

import com.example.universitytesttask.command.Command;
import com.example.universitytesttask.service.DepartmentService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AverageDepartmentSalaryCommand implements Command {
    private static final String REGEX = "^Show the average salary for the department (.+)$";
    private static final String OUTPUT = "The average salary of %s is %s";
    private final DepartmentService departmentService;

    @Override
    public void execute(String input) {
        String departmentName = extractParamFromInput(REGEX, input);
        BigDecimal averageSalary = departmentService.getAverageSalaryForDepartment(departmentName);
        System.out.printf((OUTPUT) + "%n", departmentName, averageSalary);
    }

    @Override
    public String getInputRegex() {
        return REGEX;
    }
}
