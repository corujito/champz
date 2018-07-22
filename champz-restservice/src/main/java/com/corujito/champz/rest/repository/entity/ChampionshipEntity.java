package com.corujito.champz.rest.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "championships")
public class ChampionshipEntity extends BaseEntity {

    private String name;
    private String description;

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
}
