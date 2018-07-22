package com.corujito.champz.rest.repository.entity;

import org.springframework.data.annotation.Id;

public class BaseEntity {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
