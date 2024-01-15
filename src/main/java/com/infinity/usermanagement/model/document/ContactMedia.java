package com.infinity.usermanagement.model.document;

import com.infinity.common.model.MetaData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ContactMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String isPrimary;

    private String countryCode;

    private String primaryContact;

    private String secondaryContact;

    private String primaryEmailAddress;

    private String secondaryEmailAddress;

    @ManyToOne
    private Organization organization;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MetaData metaData;
}