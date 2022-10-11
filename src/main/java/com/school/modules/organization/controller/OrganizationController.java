package com.school.modules.organization.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.modules.organization.model.Organization;
import com.school.modules.organization.services.OrganizationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    
    @Autowired
    OrganizationService organizationService;

    @GetMapping
    public @ResponseBody List<Organization> list() {
        return organizationService.listAll();
    }
    
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Organization organization) {
        organizationService.execute(organization);
        return new ResponseEntity<>("Organização criada com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/update/{orgID}")
    public ResponseEntity<Organization> update(@PathVariable("orgID") Long orgID, @RequestBody Organization organization) {
        organizationService.updateOrganization(orgID, organization);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
