package com.example.universitytesttask.command.impl;

import com.example.universitytesttask.command.Command;
import com.example.universitytesttask.model.Degree;
import com.example.universitytesttask.service.DepartmentService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentStatisticsCommand implements Command {
    private static final String REGEX = "^Show (.+) statistics$";
    private final DepartmentService departmentService;

    @Override
    public void execute(String input) {
        String departmentName = extractParamFromInput(REGEX, input);
        Map<Degree, Long> departmentStatistics = departmentService
                .getDepartmentStatisticsMap(departmentName);
        departmentStatistics.forEach((degree, count) ->
                System.out.printf("%s - %s%n", degree.getName(), count)
        );
    }

    @Override
    public String getInputRegex() {
        return REGEX;
    }
}
