package com.example.universitytesttask.command.impl;

import com.example.universitytesttask.command.Command;
import com.example.universitytesttask.model.Department;
import com.example.universitytesttask.model.Lector;
import com.example.universitytesttask.service.DepartmentService;
import com.example.universitytesttask.service.LectorService;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GlobalSearchCommand implements Command {
    private static final String REGEX = "^Global search by (.+)$";
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    @Override
    public void execute(String input) {
        String query = extractParamFromInput(REGEX, input);
        String departmentNames = extractNamesFromList(
                departmentService.getDepartmentsContainingQuery(query),
                Department::getName
        );

        if (StringUtils.isNotBlank(departmentNames)) {
            System.out.printf("Departments: %s%n", departmentNames);
        }

        String lectorsFullNames = extractNamesFromList(
                lectorService.getLectorsContainingQuery(query),
                Lector::getFullName
        );

        if (StringUtils.isNotBlank(lectorsFullNames)) {
            System.out.printf("Lectors: %s%n", lectorsFullNames);
        }

        if (StringUtils.isBlank(departmentNames) && StringUtils.isBlank(lectorsFullNames)) {
            System.out.println("Nothing was found");
        }
    }

    private <T> String extractNamesFromList(
            List<T> list,
            Function<T, String> nameExtractionFunction
    ) {
        return list.stream().map(nameExtractionFunction).collect(Collectors.joining(", "));
    }

    @Override
    public String getInputRegex() {
        return REGEX;
    }
}
