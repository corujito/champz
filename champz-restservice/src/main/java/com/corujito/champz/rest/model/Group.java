package com.corujito.champz.rest.model;

import java.util.List;

public class Group extends BaseDomain {

    private int order;
    private String name;

    private Phase phase;
    private List<GroupTeamPresence> teams;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public List<GroupTeamPresence> getTeams() {
        return teams;
    }

    public void setTeams(List<GroupTeamPresence> teams) {
        this.teams = teams;
    }

    public Group withId(String id) {
        setId(id);
        return this;
    }

    public Group withName(String name) {
        setName(name);
        return this;
    }

    public Group withOrder(int order) {
        withOrder(order);
        return this;
    }

    public Group withPhase(Phase phase) {
        setPhase(phase);
        return this;
    }

    public Group withTeams(List<GroupTeamPresence> participants) {
        setTeams(participants);
        return this;
    }
}
