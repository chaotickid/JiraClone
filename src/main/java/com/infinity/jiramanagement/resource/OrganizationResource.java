package com.infinity.jiramanagement.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infinity.jiramanagement.model.view.OrganizationVM;
import com.infinity.jiramanagement.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/organizaiton")
public class OrganizationResource {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/create")
    public ResponseEntity<OrganizationVM> createOrganizationVM (@RequestBody OrganizationVM organizationVM) throws JsonProcessingException {
        log.debug("Create organization requested =>");
        return new ResponseEntity<>(organizationService.createOrg(organizationVM), HttpStatus.CREATED);
    }
}