package ru.mail.dekster.igor.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Department extends BaseEntity {
    private String name;
    private List<Employee> employees;
}