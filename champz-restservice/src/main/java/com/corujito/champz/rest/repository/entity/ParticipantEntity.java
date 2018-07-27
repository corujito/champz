package com.corujito.champz.rest.repository.entity;

public class ParticipantEntity extends BaseEntity {

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
}
