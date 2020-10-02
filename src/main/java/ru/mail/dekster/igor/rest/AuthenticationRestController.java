package ru.mail.dekster.igor.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.dekster.igor.dto.AuthenticationRequestDto;
import ru.mail.dekster.igor.models.Employee;
import ru.mail.dekster.igor.security.jwt.JwtTokenProvider;
import ru.mail.dekster.igor.services.employee.EmployeeService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final EmployeeService employeeService;

    @Autowired
    public AuthenticationRestController(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, EmployeeService employeeService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.employeeService = employeeService;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String userName = requestDto.getUserName();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, requestDto.getPassword()));
            Employee employee = employeeService.findByUserName(userName);

            if (Objects.isNull(employee)) {
                throw new UsernameNotFoundException("Employee with userName :" + userName + " not found");
            }

            String token = tokenProvider.createToken(userName, employee.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("userName", userName);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            log.info("IN login - employee with userName and password: {} invalid ", requestDto);
            throw new BadCredentialsException("Invalid userName or Password");
        }
    }
}