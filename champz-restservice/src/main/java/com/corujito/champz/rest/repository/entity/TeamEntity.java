package com.corujito.champz.rest.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import com.corujito.champz.rest.model.Location;
import com.corujito.champz.rest.model.TeamType;

@Document(collection = "teams")
public class TeamEntity extends BaseEntity {

    private String userId;
    private String name;
    private String nickname;
    private String popularName;
    private TeamType type;
    private Location teamLocation;
    private String symbolImage;
    private String jerseyImage;

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
}
