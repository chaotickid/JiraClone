package com.infinity.jiramanagement.model.view;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectsVM {
    private String name;

    private String description;

    private String status;

    private String owner;

    private String startDate;

    private String endDate;
}