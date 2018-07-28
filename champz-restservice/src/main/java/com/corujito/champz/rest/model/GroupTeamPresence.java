package com.corujito.champz.rest.model;

public class GroupTeamPresence extends BaseDomain {

    private Group group;
    private Team team;
    private int initialPoints;

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
