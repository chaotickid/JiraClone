package com.infinity.usermanagement.model.view;

import com.infinity.usermanagement.model.document.PrimaryDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVM {

    private String email;

    private String password;

    private PrimaryDetails primaryDetails;
}