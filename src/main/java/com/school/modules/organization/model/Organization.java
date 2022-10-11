package com.school.modules.organization.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private UUID orgId;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = true)
    private Long cnpj;

    @Column(unique = true, nullable = true)
    private String email;

    @Column(nullable = true)
    private String password;
}
