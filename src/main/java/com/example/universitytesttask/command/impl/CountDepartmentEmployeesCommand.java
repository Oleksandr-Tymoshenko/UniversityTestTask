package com.example.universitytesttask.command.impl;

import com.example.universitytesttask.command.Command;
import com.example.universitytesttask.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountDepartmentEmployeesCommand implements Command {
    private static final String REGEX = "^Show count of employee for (.+)$";
    private final DepartmentService departmentService;

    @Override
    public void execute(String input) {
        String departmentName = extractParamFromInput(REGEX, input);
        int count = departmentService.countEmployeesByDepartment(departmentName);
        System.out.println(count);
    }

    @Override
    public String getInputRegex() {
        return REGEX;
    }
}
