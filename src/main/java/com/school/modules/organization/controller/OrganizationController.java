package com.school.modules.organization.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.modules.organization.model.Organization;
import com.school.modules.organization.repository.OrganizationRepository;
import com.school.modules.organization.services.ListOrganizationService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    
    private final ListOrganizationService listOrganizationService;

    public OrganizationController(ListOrganizationService listOrganizationService) {
        this.listOrganizationService = listOrganizationService;
    }

    @GetMapping
    public @ResponseBody List<Organization> list() {
        return listOrganizationService.listAll();
    }
    
}
