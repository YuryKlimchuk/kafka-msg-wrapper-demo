package com.hydroyura.springboot.kafka.msg.wrapper.demo.models;

public class UpdateEmail {

    private Long id;
    private String updatedEmail;


    public UpdateEmail() {}


    public Long getId() {
        return id;
    }

    public UpdateEmail setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUpdatedEmail() {
        return updatedEmail;
    }

    public UpdateEmail setUpdatedEmail(String updatedEmail) {
        this.updatedEmail = updatedEmail;
        return this;
    }
}
