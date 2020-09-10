package ru.mail.dekster.igor.services.employee.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mail.dekster.igor.models.Employee;
import ru.mail.dekster.igor.models.Role;
import ru.mail.dekster.igor.models.enums.Status;
import ru.mail.dekster.igor.repository.EmployeeRepository;
import ru.mail.dekster.igor.repository.RoleRepository;
import ru.mail.dekster.igor.services.employee.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RoleRepository roleRepository,
                               BCryptPasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Employee register(Employee employee) {
        Role employeeRole = roleRepository.findByName("ROLE_USER");
        List<Role> employeeRoles = new ArrayList<>();
        employeeRoles.add(employeeRole);

        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setRoles(employeeRoles);
        employee.setStatus(Status.ACTIVE);

        Employee employeeRegistered = employeeRepository.save(employee);

        log.info("IN register - employee: {} successfully registered ", employeeRegistered);

        return employeeRegistered;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        log.info("IN getAll - {} employees found", employees.size());
        return employees;
    }

    @Override
    public Employee findByUserName(String userName) {
        Employee employee = employeeRepository.findByUserName(userName);
        log.info("IN findByUserName - employee: {} found by userName {}", employee, userName);
        return employee;
    }

    @Override
    public Employee findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (Objects.isNull(employee)) {
            log.warn("IN findByUserName - no employee found by id {}", id);
        }

        log.info("IN findByUserName - employee: {} found by id {}", employee, id);
        return employee;
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);

        log.info("IN delete - employee delete by id {}", id);
    }
}