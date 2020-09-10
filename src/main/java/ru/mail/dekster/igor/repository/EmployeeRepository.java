package ru.mail.dekster.igor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mail.dekster.igor.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUserName(String userName);
}