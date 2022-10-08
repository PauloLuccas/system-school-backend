package com.school.modules.user.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.school.modules.organization.model.Organization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(unique = true, nullable = true)
    private Long cpf;

    private Long enrollment;

    private String subjects;

    private Long classes;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String password;

    @OneToOne
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "classes_id", referencedColumnName = "id")
    private Classes classe;

    @ManyToOne
    @JoinColumn(name = "orgId")
    private Organization organization;
}
