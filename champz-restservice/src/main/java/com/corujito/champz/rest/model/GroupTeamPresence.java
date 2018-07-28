package com.corujito.champz.rest.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class GroupTeamPresence {

    @NotNull(groups = {Existing.class})
    @Null(groups = New.class)
    private String id;
    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Group group;
    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Team team;
    private int initialPoints;

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getInitialPoints() {
        return initialPoints;
    }

    public void setInitialPoints(int initialPoints) {
        this.initialPoints = initialPoints;
    }

    public GroupTeamPresence withId(String id) {
        setId(id);
        return this;
    }

    public GroupTeamPresence withGroup(Group group) {
        setGroup(group);
        return this;
    }

    public GroupTeamPresence withTeam(Team team) {
        setTeam(team);
        return this;
    }

    public GroupTeamPresence withInitialPoints(int initialPoints) {
        setInitialPoints(initialPoints);
        return this;
    }
}
