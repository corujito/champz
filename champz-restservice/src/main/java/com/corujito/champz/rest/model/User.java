package com.corujito.champz.rest.model;

public class User extends BaseDomain {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User withId(String id) {
        setId(id);
        return this;
    }

    public User withName(String name) {
        setName(name);
        return this;
    }

    public User withEmail(String email) {
        setEmail(email);
        return this;
    }
}
