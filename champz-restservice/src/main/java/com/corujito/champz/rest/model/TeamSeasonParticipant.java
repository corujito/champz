package com.corujito.champz.rest.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TeamSeasonParticipant {

    @NotNull(groups = {Existing.class})
    @Null(groups = New.class)
    private String id;
    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Season season;
    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Team team;

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

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public TeamSeasonParticipant withId(String id) {
        setId(id);
        return this;
    }

    public TeamSeasonParticipant withSeason(Season season) {
        setSeason(season);
        return this;
    }

    public TeamSeasonParticipant withTeam(Team team) {
        setTeam(team);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", this.id)
                .append("season", this.season)
                .append("team", this.team)
                .toString();
    }
}
