package com.school.modules.user.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Classes {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private Long classesId;

    public Classes(UUID id) {
        this.id = id;
    }
}
