package ru.mail.dekster.igor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mail.dekster.igor.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}