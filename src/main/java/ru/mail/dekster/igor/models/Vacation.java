package ru.mail.dekster.igor.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder(toBuilder = true)
@Slf4j
public class Vacation implements Serializable {
    private int id;
    private LocalDate vacation;
    private LocalDate newVacation;
    private String resolution;
    private Employee employee;
}