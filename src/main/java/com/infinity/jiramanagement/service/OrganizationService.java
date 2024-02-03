package com.infinity.jiramanagement.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinity.common.exceptionHandling.CustomResponseException;
import com.infinity.common.exceptionHandling.ErrorCodeEnum;
import com.infinity.common.utils.CommonMappingUtils;
import com.infinity.common.utils.PaginationUtils;
import com.infinity.common.utils.Utils;
import com.infinity.jiramanagement.model.document.Organization;
import com.infinity.jiramanagement.model.view.OrganizationVM;
import com.infinity.jiramanagement.model.view.PaginationVM;
import com.infinity.jiramanagement.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
            log.debug("Organization created successfully with details");
        } catch (Exception e) {
            log.error("Exception captured while creating organization");
            throw new CustomResponseException(ErrorCodeEnum.ER3001, HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
        return CommonMappingUtils.organizationToOrganizationVM(organization, modelMapper);
    }

    public List<OrganizationVM> getAll(PaginationVM paginationVM) throws JsonProcessingException {
        log.debug("Get all organization requested with {}", objectMapper.writeValueAsString(paginationVM));
        List<OrganizationVM> fetchedOrganizationVMList =  new ArrayList<>();
        PaginationUtils<Organization> pagination =  new PaginationUtils<>();
        try {
            List<Organization> filteredOrganization =
                    pagination.filterPagination(organizationRepository.findAll(), paginationVM);
            filteredOrganization.forEach(organization -> {
                OrganizationVM organizationVM = CommonMappingUtils.organizationToOrganizationVM(organization, modelMapper);
                fetchedOrganizationVMList.add(organizationVM);
            });
            log.debug("Fetched all organization successfully");
        } catch (Exception e) {
            log.error("Exception captured while creating organization");
            throw new CustomResponseException(ErrorCodeEnum.ER3001, HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
        return fetchedOrganizationVMList;
    }

}