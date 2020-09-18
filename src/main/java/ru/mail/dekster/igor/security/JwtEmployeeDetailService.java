package ru.mail.dekster.igor.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mail.dekster.igor.models.Employee;
import ru.mail.dekster.igor.security.jwt.JwtEmployee;
import ru.mail.dekster.igor.security.jwt.JwtEmployeeFactory;
import ru.mail.dekster.igor.services.employee.EmployeeService;

import java.util.Objects;

@Service
@Slf4j
public class JwtEmployeeDetailService implements UserDetailsService {

    private final EmployeeService employeeService;

    @Autowired
    public JwtEmployeeDetailService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Employee employee = employeeService.findByUserName(userName);

        if (Objects.isNull(employee)) {
            throw new UsernameNotFoundException("Employee with userName : " + userName + " not found");
        }
        JwtEmployee jwtEmployee = JwtEmployeeFactory.create(employee);
        log.info("IN loadUserByUsername - employee with userName : {} successfully loaded ", userName);
        return jwtEmployee;
    }
}