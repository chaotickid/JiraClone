package com.infinity.jiramanagement.model.view;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrganizationVM {

    private Integer id;

    private String name;

    private String description;

    private String website;

    private String industryType;

    private String logo;

    private List<AddressVM> addresses;

    private List<ContactMediaVM> contactMedia;

    private List <ProjectsVM> projects;

}