package com.school.modules.organization.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.modules.organization.model.Organization;
import com.school.modules.organization.repository.OrganizationRepository;

@Service
public class CreateOrganizationService {
    
    @Autowired
    OrganizationRepository organizationRepository;

    public Organization execute(Organization organization) {
        Organization existOrganization = organizationRepository.findByCnpj(organization.getCnpj());

        if (existOrganization != null) {
            throw new Error("Erro ao criar organização. Entre em contato com o suporte da plataforma.");
        }

        Organization createOrganzation = organizationRepository.save(organization);

        return createOrganzation;
    }

}
