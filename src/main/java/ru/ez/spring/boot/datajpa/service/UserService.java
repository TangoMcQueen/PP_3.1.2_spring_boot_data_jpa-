package ru.ez.spring.boot.datajpa.service;


import ru.ez.spring.boot.datajpa.model.User;

import java.util.List;

public interface UserService {
    List<User> listAllUsers();
    void saveOrUpdateUser(User user);
    User getUser(int id);
    void deleteUser(int id);
}
