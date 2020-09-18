package ru.mail.dekster.igor.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtEmployee implements UserDetails {
    private final Long id;
    private final String userName;
    private final String name;
    private final String surName;
    private final String password;
    private final String profession;
    private final Integer stage;
    private final Integer salary;
    private final boolean enabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtEmployee(Long id,
                       String userName,
                       String name,
                       String surName,
                       String password,
                       String profession,
                       Integer stage,
                       Integer salary,
                       boolean enabled,
                       Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.surName = surName;
        this.password = password;
        this.profession = profession;
        this.stage = stage;
        this.salary = salary;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getProfession() {
        return profession;
    }

    public Integer getStage() {
        return stage;
    }

    public Integer getSalary() {
        return salary;
    }
}