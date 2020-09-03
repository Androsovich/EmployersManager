package ru.mail.dekster.igor.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Department extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Employee> employees;
}