package com.school.modules.user.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Any;

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

    @NotEmpty(message = "O campo Nome é obrigatório!")
    private String name;

    @Column(unique = true)
    @NotEmpty(message = "O campo CPF é obrigatório!")
    private Long cpf;

    private Long enrollment;

    private String subjects;

    private Long classes;

    @NotEmpty(message = "O campo E-mail é obrigatório!")
    private String email;

    @NotEmpty(message = "O campo Password é obrigatório!")
    private String password;

    @NotEmpty(message = "O campo Permissão é obrigatório!")
    private String role;

    private String classe;

    @Column(name = "org_id")
    @NotEmpty(message = "O campo Organização é obrigatório!")
    private Long orgId;

    @OneToMany
    private List<Role> roles;
}
