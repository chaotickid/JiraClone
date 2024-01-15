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
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    private String ticketName;

    private String description;

    private String assignee;

    private String reporter;

    private String dueDate;

    private String startDate;

    private String comments;

    private String priority;

    @OneToOne
    private TicketStatus ticketStatus;

    @OneToOne
    private TicketIssueType ticketIssueType;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MetaData metaData;
}