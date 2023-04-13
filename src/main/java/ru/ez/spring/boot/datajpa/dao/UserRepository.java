package ru.ez.spring.boot.datajpa.dao;

import ru.ez.spring.boot.datajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}