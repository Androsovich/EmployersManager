package ru.mail.dekster.igor.services.employee;

import ru.mail.dekster.igor.models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee register(Employee employee);

    List<Employee> getAll();

    Employee findByUserName(String userName);

    Employee findById(Long id);

    void delete(Long id);
}