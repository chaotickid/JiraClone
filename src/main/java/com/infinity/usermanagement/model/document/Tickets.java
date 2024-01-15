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
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MetaData metaData;
}