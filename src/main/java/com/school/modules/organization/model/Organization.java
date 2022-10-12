package com.school.modules.organization.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue
    @Column(updatable = false, unique = true)
    private Long orgId;

    @NotEmpty(message = "O campo Nome é obrigatório!")
    private String nome;

    @NotEmpty(message = "O campo CNPJ é obrigatório!")
    private String cnpj;

    @NotEmpty(message = "O campo E-mail é obrigatório!")
    private String email;

    @NotEmpty(message = "O campo Senha é obrigatório!")
    private String password;

    @Column(columnDefinition = "mediumtext")
    private String picture;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp createdAt;

    @UpdateTimestamp
    Timestamp updatedAt;
}
