package com.hydroyura.springboot.kafka.msg.wrapper.demo.models;

public class CreateUser {

    private String name, surname, email;


    public CreateUser() {}


    public String getName() {
        return name;
    }

    public CreateUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public CreateUser setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateUser setEmail(String email) {
        this.email = email;
        return this;
    }
}
