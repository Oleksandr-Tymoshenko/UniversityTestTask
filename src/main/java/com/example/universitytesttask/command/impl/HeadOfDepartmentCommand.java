package com.example.universitytesttask.command.impl;

import com.example.universitytesttask.command.Command;
import com.example.universitytesttask.model.Department;
import com.example.universitytesttask.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeadOfDepartmentCommand implements Command {
    private static final String REGEX = "^Who is head of department (.+)$";
    private static final String OUTPUT = "Head of %s department is %s";
    private final DepartmentService departmentService;

    @Override
    public void execute(String input) {
        String departmentName = extractParamFromInput(REGEX, input);
        Department department = departmentService.getDepartmentByName(departmentName);
        System.out.printf((OUTPUT) + "%n",
                departmentName, department.getHead().getFullName()
        );
    }

    @Override
    public String getInputRegex() {
        return REGEX;
    }
}
