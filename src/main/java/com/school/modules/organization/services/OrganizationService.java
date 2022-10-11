package com.school.modules.organization.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.modules.organization.model.Organization;
import com.school.modules.organization.repository.OrganizationRepository;

@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    public List<Organization> listAll() {
        return organizationRepository.findAll();
    }

    public Organization execute(Organization organization) {
        Organization existOrganization = organizationRepository.findByCnpj(organization.getCnpj());

        if (existOrganization != null) {
            throw new Error("Erro ao criar organização. Entre em contato com o suporte da plataforma.");
        }

        Organization createOrganzation = organizationRepository.save(organization);

        return createOrganzation;
    }

    public Organization getOrganizationById(Long orgId) {
        return organizationRepository.findByOrgId(orgId);
    } 

    public void updateOrganization(Long orgId, Organization organization) { 
        Organization searchOrganization = organizationRepository.findByOrgId(orgId);

        if (searchOrganization == null) {
            throw new Error("Erro ao atualizar dados da Organização.");
        }

        searchOrganization.setCnpj(organization.getCnpj());
        searchOrganization.setNome(organization.getNome());
        searchOrganization.setEmail(organization.getEmail());
        searchOrganization.setPassword(organization.getPassword());

        organizationRepository.save(searchOrganization);
    }
    
}
