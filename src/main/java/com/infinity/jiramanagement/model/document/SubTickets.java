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
public class SubTickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    private String summary;

    private String targetBranch;

    private String storyPoints;

    private String description;

    private String assignee;

    private String reporter;

    private String dueDate;

    private String startDate;

    private String comments;

    private String priority;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private TicketStatus ticketStatus;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private TicketIssueType ticketIssueType;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MetaData metaData;
}