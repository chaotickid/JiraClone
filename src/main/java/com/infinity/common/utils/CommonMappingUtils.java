package com.infinity.common.utils;

import com.infinity.jiramanagement.model.document.Organization;
import com.infinity.jiramanagement.model.document.User;
import com.infinity.jiramanagement.model.view.OrganizationVM;
import com.infinity.jiramanagement.model.view.UserVM;
import org.modelmapper.ModelMapper;

public class CommonMappingUtils {

    //******************************* Organization *******************************

    public static OrganizationVM organizationToOrganizationVM(Organization organization, ModelMapper modelMapper){
        return modelMapper.map(organization, OrganizationVM.class);
    }

    public static Organization organizationVMToOrganization(OrganizationVM organizationVM, ModelMapper modelMapper){
        return modelMapper.map(organizationVM, Organization.class);
    }

    //******************************* User *******************************


    public static User userVMToUser(UserVM userVM, ModelMapper modelMapper){
        return modelMapper.map(userVM, User.class);
    }

    public static UserVM userToUserVM(User user, ModelMapper modelMapper){
        return modelMapper.map(user, UserVM.class);
    }

}
