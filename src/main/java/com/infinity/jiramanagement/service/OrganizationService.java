package com.infinity.jiramanagement.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinity.common.exceptionHandling.CustomResponseException;
import com.infinity.common.exceptionHandling.ErrorCodeEnum;
import com.infinity.common.utils.CommonMappingUtils;
import com.infinity.common.utils.Utils;
import com.infinity.jiramanagement.model.document.Organization;
import com.infinity.jiramanagement.model.view.OrganizationVM;
import com.infinity.jiramanagement.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class OrganizationService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationVM createOrg(OrganizationVM organizationVM) throws JsonProcessingException {
        log.debug("Creating org with request body: {}", objectMapper.writeValueAsString(organizationVM));
        Organization organization = CommonMappingUtils.organizationVMToOrganization(organizationVM, modelMapper);
        try {
            organization = organizationRepository.save(organization);
            //project add
            organization.addProjectUnderOrganization(organization.getProjects());

            //meta data
            organization.setMetaData(Utils.createMetaData("ORG", null));
            log.debug("Organization created successfully with details: {}", objectMapper.writeValueAsString(organization));
        } catch (Exception e) {
            log.error("Exception captured while creating organization");
            throw new CustomResponseException(ErrorCodeEnum.ER3001, HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
        return CommonMappingUtils.organizationToOrganizationVM(organization, modelMapper);
    }

}