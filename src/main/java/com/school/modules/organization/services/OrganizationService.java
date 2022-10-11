package com.school.modules.organization.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.modules.organization.model.Organization;
import com.school.modules.organization.repository.OrganizationRepository;
import com.school.modules.validation.services.ValidationService;

@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    ValidationService validationService;

    public List<Organization> listAll() {
        return organizationRepository.findAll();
    }

    public Organization execute(Organization organization) {
        Organization existOrganization = organizationRepository.findByCnpj(organization.getCnpj());
        boolean validaCNPJ = validationService.isCNPJ(organization.getCnpj());

        if (existOrganization != null) {
            throw new Error("Erro ao criar organização. Entre em contato com o suporte da plataforma.");
        } else if (validaCNPJ == false) {
            throw new Error("CNPJ inválido.");
        }

        Organization createOrganzation = organizationRepository.save(organization);

        return createOrganzation;
    }

    public Organization getOrganizationById(Long orgId) {
        return organizationRepository.findByOrgId(orgId);
    } 

    public void updateOrganization(Long orgId, Organization organization) { 
        Organization searchOrganization = organizationRepository.findByOrgId(orgId);
        
        boolean validaCNPJ = validationService.isCNPJ(organization.getCnpj());

        if (searchOrganization == null) {
            throw new Error("Erro ao atualizar dados da Organização.");
        } else if (validaCNPJ == false) {
            throw new Error("CNPJ inválido.");
        }

        searchOrganization.setCnpj(organization.getCnpj());
        searchOrganization.setNome(organization.getNome());
        searchOrganization.setEmail(organization.getEmail());
        searchOrganization.setPassword(organization.getPassword());

        organizationRepository.save(searchOrganization);
    }
    
}
