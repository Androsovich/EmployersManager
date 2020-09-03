package ru.mail.dekster.igor.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class Employee extends BaseEntity {
    private Department Department;
    private String name;
    private String surname;
    private String patronymic;
    private Integer salary;
    private Vacation vacation;
    private String profession;
    private Integer stage;
    private Role role;
}