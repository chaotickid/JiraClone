package com.infinity.jiramanagement.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infinity.jiramanagement.model.view.OrganizationVM;
import com.infinity.jiramanagement.model.view.PaginationVM;
import com.infinity.jiramanagement.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class OrganizationResource {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/organization")
    public ResponseEntity<OrganizationVM> createOrganizationVM(@RequestBody OrganizationVM organizationVM)
            throws JsonProcessingException {
        log.debug("Create organization requested =>");
        return new ResponseEntity<>(organizationService.createOrg(organizationVM), HttpStatus.CREATED);
    }

    @GetMapping("/organization")
    public ResponseEntity<List<OrganizationVM>> getAllOrganization(
            @RequestParam(name = "offset", required = false) Integer offset,
            @RequestParam(name = "limit", required = false) Integer limit,
            PaginationVM paginationVM) throws JsonProcessingException {
        log.debug("Get all organization requested => limit: {} and offset: {}", paginationVM.getLimit(),
                paginationVM.getOffset());
        return new ResponseEntity<>(organizationService.getAll(paginationVM), HttpStatus.OK);
    }
}