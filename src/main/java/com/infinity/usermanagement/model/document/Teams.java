package com.infinity.usermanagement.model.document;

import com.infinity.common.model.MetaData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String teamLimit;

    @ManyToMany
    @JoinTable(
            name = "teams_user",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> user;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MetaData metaData;

    @ManyToMany(mappedBy = "teams")
    private Set<Projects> projects;
}