package com.infinity.jiramanagement.repository;

import com.infinity.jiramanagement.model.document.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}