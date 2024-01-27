package com.infinity.jiramanagement.model.view;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactMediaVM {
    private String isPrimary;

    private String countryCode;

    private String primaryContact;

    private String secondaryContact;

    private String primaryEmailAddress;

    private String secondaryEmailAddress;

}