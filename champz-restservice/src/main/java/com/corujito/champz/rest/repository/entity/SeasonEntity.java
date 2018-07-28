package com.corujito.champz.rest.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seasons")
public class SeasonEntity extends BaseEntity {

    private String title;
    private String regulation;
    private String championshipId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegulation() {
        return regulation;
    }

    public void setRegulation(String regulation) {
        this.regulation = regulation;
    }

    public String getChampionshipId() {
        return championshipId;
    }

    public void setChampionshipId(String championshipId) {
        this.championshipId = championshipId;
    }

    public SeasonEntity withId(String id) {
        setId(id);
        return this;
    }

    public SeasonEntity withTitle(String title) {
        setTitle(title);
        return this;
    }

    public SeasonEntity withRegulation(String regulation) {
        setRegulation(regulation);
        return this;
    }

    public SeasonEntity withChampionshipId(String championshipId) {
        setChampionshipId(championshipId);
        return this;
    }
}
