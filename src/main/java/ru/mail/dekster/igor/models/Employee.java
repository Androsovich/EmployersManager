package ru.mail.dekster.igor.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@Slf4j
public class Employee implements Serializable {
    private Integer id;
    private Department Department;
    private String name;
    private String surname;
    private String patronymic;
    private Integer salary;
    private Vacation vacation;
    private String profession;
    private Integer stage;
    private String role;
}