package ru.mail.dekster.igor.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vacations")
@Getter
@Setter
public class Vacation extends BaseEntity {

    @Column(name = "vacation")
    private LocalDate vacation;

    @Column(name = "newVacation")
    private LocalDate newVacation;

    @Column(name = "description")
    private String description;

    @OneToOne(optional = false, mappedBy = "vacation", cascade = CascadeType.ALL)
    private Employee employee;
}