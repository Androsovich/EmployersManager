package ru.mail.dekster.igor.dto;

import lombok.Getter;
import lombok.Setter;
import ru.mail.dekster.igor.models.Employee;

@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String userName;
    private String name;
    private String surName;

    public Employee toEmployee(){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setUserName(userName);
        employee.setName(name);
        employee.setSurname(surName);

        return employee;
    }

    public static EmployeeDto fromEmployee(Employee employee) {
        EmployeeDto userDto = new EmployeeDto();
        userDto.setId(employee.getId());
        userDto.setUserName(employee.getUserName());
        userDto.setName(employee.getName());
        userDto.setSurName(employee.getSurname());

        return userDto;
    }
}
