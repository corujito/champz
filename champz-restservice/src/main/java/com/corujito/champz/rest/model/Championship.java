package com.corujito.champz.rest.model;

public class Championship extends BaseDomain {

    private String name;
    private String description;
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Championship withId(String id) {
        setId(id);
        return this;
    }

    public Championship withName(String name) {
        setName(name);
        return this;
    }

    public Championship withDescription(String description) {
        setDescription(description);
        return this;
    }

    public Championship withUser(User user) {
        setUser(user);
        return this;
    }
}
