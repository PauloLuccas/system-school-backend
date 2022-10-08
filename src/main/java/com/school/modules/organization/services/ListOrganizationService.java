package com.school.modules.organization.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.modules.organization.model.Organization;
import com.school.modules.organization.repository.OrganizationRepository;

@Service
public class ListOrganizationService {
    
    @Autowired
    OrganizationRepository organizationRepository;

    public List<Organization> listAll() {
        return organizationRepository.findAll();
    }
}
