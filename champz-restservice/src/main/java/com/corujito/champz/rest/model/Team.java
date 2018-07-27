package com.corujito.champz.rest.model;

import java.util.List;

public class Team extends BaseDomain {

    private User user;
    private String name;
    private String nickname;
    private String popularName;
    private TeamType type;
    private Location teamLocation;
    private String symbolImage;
    private String jerseyImage;
    private List<Passage> passages;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Passage> getPassages() {
        return passages;
    }

    public void setPassages(List<Passage> passages) {
        this.passages = passages;
    }

    public Team withId(String id) {
        setId(id);
        return this;
    }

    public Team withUser(User user) {
        setUser(user);
        return this;
    }

    public Team withName(String name) {
        setName(name);
        return this;
    }

    public Team withNickname(String nickname) {
        setNickname(nickname);
        return this;
    }

    public Team withPopularName(String popularName) {
        setPopularName(popularName);
        return this;
    }

    public Team withType(TeamType type) {
        setType(type);
        return this;
    }

    public Team withTeamLocation(Location teamLocation) {
        setTeamLocation(teamLocation);
        return this;
    }

    public Team withSymbolImage(String symbolImage) {
        setSymbolImage(symbolImage);
        return this;
    }

    public Team withJerseyImage(String jerseyImage) {
        setJerseyImage(jerseyImage);
        return this;
    }

    public Team withPaassages(List<Passage> passages) {
        setPassages(passages);
        return this;
    }
}
