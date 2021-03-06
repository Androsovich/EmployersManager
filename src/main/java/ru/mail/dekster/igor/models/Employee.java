package ru.mail.dekster.igor.models;

import lombok.Getter;
import lombok.Setter;
import ru.mail.dekster.igor.models.enums.Status;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employers")
@Getter
@Setter
public class Employee extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department")
    private Department department;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private Integer salary;

    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @Column(name = "profession")
    private String profession;

    @Column(name = "stage")
    private Integer stage;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_roles",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
}