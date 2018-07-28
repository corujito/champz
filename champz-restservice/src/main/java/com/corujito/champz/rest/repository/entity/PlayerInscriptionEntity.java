package com.corujito.champz.rest.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "player_inscriptions")
public class PlayerInscriptionEntity extends BaseEntity {

    private String seasonId;
    private String playerId;
    private String teamId;

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public PlayerInscriptionEntity withId(String id) {
        setId(id);
        return this;
    }

    public PlayerInscriptionEntity withSeasonId(String seasonId) {
        setSeasonId(seasonId);
        return this;
    }

    public PlayerInscriptionEntity withPlayerId(String playerId) {
        setPlayerId(playerId);
        return this;
    }

    public PlayerInscriptionEntity withTeamId(String teamId) {
        setTeamId(teamId);
        return this;
    }
}
