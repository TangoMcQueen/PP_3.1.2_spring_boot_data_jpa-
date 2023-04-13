package ru.ez.spring.boot.datajpa.service;


import org.springframework.stereotype.Service;
import ru.ez.spring.boot.datajpa.dao.UserRepository;
import ru.ez.spring.boot.datajpa.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public void saveOrUpdateUser(User user) {
        userRepository.save(user);
    }
    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        User user = null;
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()) {
            user = optional.get();
        }
        return user;
    }
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}