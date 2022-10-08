package com.school.modules.organization.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.school.modules.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private UUID orgId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = true)
    private Long cnpj;

    @OneToMany
    @JoinColumn(name = "orgId")
    private List<User> user;

    public Organization() {
        user = new ArrayList<>();
    }
}
