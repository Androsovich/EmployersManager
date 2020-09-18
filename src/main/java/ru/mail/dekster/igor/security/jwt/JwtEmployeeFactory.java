package ru.mail.dekster.igor.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.mail.dekster.igor.models.Employee;
import ru.mail.dekster.igor.models.Role;
import ru.mail.dekster.igor.models.enums.Status;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtEmployeeFactory {

    public JwtEmployeeFactory() {
    }

    public static JwtEmployee create(Employee employee) {
        return new JwtEmployee(
                employee.getId(),
                employee.getUserName(),
                employee.getName(),
                employee.getSurname(),
                employee.getPassword(),
                employee.getProfession(),
                employee.getStage(),
                employee.getSalary(),
                employee.getStatus().equals(Status.ACTIVE),
                null
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(List<Role> employeeRoles) {
        return employeeRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}