package com.school.modules.organization.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.modules.organization.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    
    Organization findByCnpj(Long cnpj);

    Organization findByOrgId(Long orgId);
}
