package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

//используем Data JPA, достать роль из базы
@Repository
public interface RoleDaoLayer extends JpaRepository<Role, Long> {
}
