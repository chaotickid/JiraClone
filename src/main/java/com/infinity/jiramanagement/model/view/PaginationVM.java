package com.infinity.jiramanagement.model.view;

import lombok.Data;

@Data
public class PaginationVM {
    private Integer limit;
    private Integer offset;
}