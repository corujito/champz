package com.corujito.champz.rest.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "team_season_participants")
public class TeamSeasonParticipantEntity extends BaseEntity {

    private String seasonId;
    private String teamId;

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public TeamSeasonParticipantEntity withId(String id) {
        setId(id);
        return this;
    }

    public TeamSeasonParticipantEntity withSeasonId(String seasonId) {
        setSeasonId(seasonId);
        return this;
    }

    public TeamSeasonParticipantEntity withTeamId(String teamId) {
        setTeamId(teamId);
        return this;
    }
}
