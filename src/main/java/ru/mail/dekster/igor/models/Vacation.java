package ru.mail.dekster.igor.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder(toBuilder = true)
public class Vacation extends BaseEntity {
    private LocalDate vacation;
    private LocalDate newVacation;
    private String resolution;
    private Employee employee;
}