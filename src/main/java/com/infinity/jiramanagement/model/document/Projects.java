package com.infinity.jiramanagement.model.document;

import com.infinity.common.model.MetaData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private String status;

    private String owner;

    private String startDate;

    private String endDate;

    @ManyToOne
    private Organization organization;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MetaData metaData;

    @ManyToMany
    @JoinTable(
            name = "project_teams",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "teams_id"))
    private Set<Teams> teams = new HashSet<>();

}
