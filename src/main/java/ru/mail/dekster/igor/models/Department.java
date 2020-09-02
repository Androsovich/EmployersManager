package ru.mail.dekster.igor.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@Slf4j
public class Department {
    private long id;
    private String name;
    private List<Employee> employees;
}