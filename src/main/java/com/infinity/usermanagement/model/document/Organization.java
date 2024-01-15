package com.infinity.usermanagement.model.document;

import com.infinity.common.model.MetaData;
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

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List <Projects> projects = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MetaData metaData;
}