package com.corujito.champz.rest.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Team {

    @NotNull(groups = {Existing.class, TeamSeasonParticipant.New.class, TeamSeasonParticipant.Existing.class,
            PlayerTeamPassage.New.class, PlayerTeamPassage.Existing.class, PlayerMatchAttendance.New.class,
            PlayerMatchAttendance.Existing.class, PlayerInscription.New.class, PlayerInscription.Existing.class,
            Match.New.class, Match.Existing.class, GroupTeamPresence.New.class, GroupTeamPresence.Existing.class})
    @Null(groups = New.class)
    private String id;
    @NotNull
    @NotBlank
    private String name;
    private String popularName;
    private String nickname;
    private String symbolImage;
    private String jerseyImage;
    private Location teamLocation;
    private TeamType type;

    public interface Existing {
    }

    public interface New {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    private User user;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Team rhs = (Team) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(id, rhs.id)
                .append(jerseyImage, rhs.jerseyImage)
                .append(name, rhs.name)
                .append(nickname, rhs.nickname)
                .append(popularName, rhs.popularName)
                .append(symbolImage, rhs.symbolImage)
                .append(teamLocation, rhs.teamLocation)
                .append(type, rhs.type)
                .append(user, rhs.user)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(jerseyImage)
                .append(name)
                .append(nickname)
                .append(popularName)
                .append(symbolImage)
                .append(teamLocation)
                .append(type)
                .append(user)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", this.id)
                .append("jerseyImage", this.jerseyImage)
                .append("name", this.name)
                .append("nickname", this.nickname)
                .append("popularName", this.popularName)
                .append("symbolImage", this.symbolImage)
                .append("teamLocation", this.teamLocation)
                .append("type", this.type)
                .append("user", this.user)
                .toString();
    }
}
