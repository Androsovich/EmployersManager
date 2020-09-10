package ru.mail.dekster.igor.services.employee.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mail.dekster.igor.models.Employee;
import ru.mail.dekster.igor.repository.EmployeeRepository;
import ru.mail.dekster.igor.repository.RoleRepository;
import ru.mail.dekster.igor.services.employee.EmployeeService;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Employee register(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public Employee findByNameAndSurname(String name, String surName) {
        return null;
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
