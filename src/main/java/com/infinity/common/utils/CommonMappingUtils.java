package com.infinity.common.utils;

import com.infinity.jiramanagement.model.document.Organization;
import com.infinity.jiramanagement.model.view.OrganizationVM;
import org.modelmapper.ModelMapper;

public class CommonMappingUtils {

    //******************************* Organization *******************************

    public static OrganizationVM organizationToOrganizationVM(Organization organization, ModelMapper modelMapper){
        return modelMapper.map(organization, OrganizationVM.class);
    }

    public static Organization organizationVMToOrganization(OrganizationVM organizationVM, ModelMapper modelMapper){
        return modelMapper.map(organizationVM, Organization.class);
    }

}
