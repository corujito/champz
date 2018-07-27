package com.corujito.champz.rest.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserEntity extends BaseEntity {

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
}
