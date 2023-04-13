package ru.ez.spring.boot.datajpa.model;


import ru.ez.spring.boot.datajpa.model.validator.CheckEmail;
import javax.persistence.*;

import javax.validation.constraints.*;

@Entity
@Table(name = "users2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    @Size(min = 2, max = 15, message = "Name must be min 2 symbols")
    @NotBlank(message = "Name should not be empty")
//    @Pattern(regexp = "/^(?=.{1,15}$)[а-яёА-ЯЁ]+(?:[-' ][а-яёА-ЯЁ]+)*$/")
//    @Pattern(message = "Bad formed person name: ${validatedValue}", regexp = "^[A-Za-zА-Яа-яЁё]$")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё]{2,15}$")
    private String name;
    @Column
    @Size(min = 2, max = 25, message = "Surname must be min 2 symbols")
    @NotBlank(message = "Surname should not be empty")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё]{2,15}$")
//    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё]$", message = "please use pattern [A-Za-zА-Яа-яЁё]")
    private String surname;
    @Column
    @NotNull(message = "Age should not be empty")
    @Min(value = 18, message = "must be greater than 17")
    @Max(value = 100, message = "must be less than 101")
    private int age;
    @Column
    @Size(min = 7, max = 40, message = "Email must be min 7 symbols")
    @CheckEmail
    private String email;

    public User() {
    }
    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}