package ru.mail.dekster.igor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequestDto {
    private String userName;
    private String password;
}