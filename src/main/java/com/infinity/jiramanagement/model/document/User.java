package com.infinity.jiramanagement.model.document;

import com.infinity.common.model.MetaData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email
    private String email;

    private String password;

    private String role;

    private String uuid = UUID.randomUUID().toString();

    private String lastLoginAt;

    private String isAccountVerified;

    private String isEmailVerified;

    private String isAccountLocked;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private PrimaryDetails primaryDetails;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Organization organization;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MetaData metaData;

    @ManyToMany(mappedBy = "user")
    private Set<Teams> teams = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tickets> ticket;

}