package com.corujito.champz.rest.model;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class Group {

    @NotNull(groups = {Existing.class, Match.New.class, Match.Existing.class, GroupTeamPresence.New.class,
            GroupTeamPresence.Existing.class})
    @Null(groups = New.class)
    private String id;
    private int order;
    private String name;

    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Phase phase;
    private List<GroupTeamPresence> teams;

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
