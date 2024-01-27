package com.infinity.jiramanagement.model.view;

import com.infinity.jiramanagement.model.document.PrimaryDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVM {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private PrimaryDetails primaryDetails;
}