package com.infinity.jiramanagement.model.document;

import com.infinity.common.model.MetaData;
import com.infinity.common.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private String website;

    private String industryType;

    private String logo;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ContactMedia> contactMedia = new ArrayList<>();


    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List <Projects> projects = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MetaData metaData;

    //*********** HELPER FUNCTIONS ***********
    public void addProjectUnderOrganization(List<Projects> project) {
        this.projects.addAll(project);
        project.forEach(fetchedProjectFromList -> {
            fetchedProjectFromList.setMetaData(Utils.createMetaData("PROJECT", null));
            fetchedProjectFromList.setOrganization(this);
        });
    }

}