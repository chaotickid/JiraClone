package com.infinity.jiramanagement.model.document;

import com.infinity.common.model.MetaData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String pinCode;

    private String houseNo;

    private String area;

    private String landMark;

    private String city;

    private String state;

    private String country;

    private boolean isPrimary;

    @ManyToOne
    private Organization organization;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MetaData metaData;
}
