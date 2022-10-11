package com.school.modules.organization.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.modules.organization.model.Organization;
import com.school.modules.organization.services.CreateOrganizationService;
import com.school.modules.organization.services.ListOrganizationService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    
    private final ListOrganizationService listOrganizationService;
    private final CreateOrganizationService createOrganizationService;

    public OrganizationController(ListOrganizationService listOrganizationService, CreateOrganizationService createOrganizationService) {
        this.listOrganizationService = listOrganizationService;
        this.createOrganizationService = createOrganizationService;
    }

    @GetMapping
    public @ResponseBody List<Organization> list() {
        return listOrganizationService.listAll();
    }
    
    @PostMapping("/create")
    public Organization create(@RequestBody Organization organization) {
        return createOrganizationService.execute(organization);
    }
}
