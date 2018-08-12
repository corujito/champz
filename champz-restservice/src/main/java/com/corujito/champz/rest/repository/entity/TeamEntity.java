package com.corujito.champz.rest.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import com.corujito.champz.rest.model.Location;
import com.corujito.champz.rest.model.TeamType;

@Document(collection = "teams")
public class TeamEntity extends BaseEntity {

    private String name;
    private String popularName;
    private String nickname;
    private String abbreviation;
    private String symbolImage;
    private String jerseyImage;
    private Location teamLocation;
    private TeamType type;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPopularName() {
        return popularName;
    }

    public void setPopularName(String popularName) {
        this.popularName = popularName;
    }

    public TeamType getType() {
        return type;
    }

    public void setType(TeamType type) {
        this.type = type;
    }

    public Location getTeamLocation() {
        return teamLocation;
    }

    public void setTeamLocation(Location teamLocation) {
        this.teamLocation = teamLocation;
    }

    public String getSymbolImage() {
        return symbolImage;
    }

    public void setSymbolImage(String symbolImage) {
        this.symbolImage = symbolImage;
    }

    public String getJerseyImage() {
        return jerseyImage;
    }

    public void setJerseyImage(String jerseyImage) {
        this.jerseyImage = jerseyImage;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public TeamEntity withId(String id) {
        setId(id);
        return this;
    }

    public TeamEntity withUserId(String userId) {
        setUserId(userId);
        return this;
    }

    public TeamEntity withName(String name) {
        setName(name);
        return this;
    }

    public TeamEntity withNickname(String nickname) {
        setNickname(nickname);
        return this;
    }

    public TeamEntity withPopularName(String popularName) {
        setPopularName(popularName);
        return this;
    }

    public TeamEntity withType(TeamType type) {
        setType(type);
        return this;
    }

    public TeamEntity withTeamLocation(Location teamLocation) {
        setTeamLocation(teamLocation);
        return this;
    }

    public TeamEntity withSymbolImage(String symbolImage) {
        setSymbolImage(symbolImage);
        return this;
    }

    public TeamEntity withJerseyImage(String jerseyImage) {
        setJerseyImage(jerseyImage);
        return this;
    }

    public TeamEntity withAbbreviation(String abbreviation) {
        setAbbreviation(abbreviation);
        return this;
    }
}
