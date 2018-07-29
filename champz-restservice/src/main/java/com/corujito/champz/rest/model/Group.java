package com.corujito.champz.rest.model;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Group {

    @NotNull(groups = {Existing.class, Match.New.class, Match.Existing.class})
    @Null(groups = New.class)
    private String id;
    private int order;
    private String name;

    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Phase phase;
    private List<GroupTeamPresence> presences;

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

    public List<GroupTeamPresence> getPresences() {
        return presences;
    }

    public void setPresences(List<GroupTeamPresence> presences) {
        this.presences = presences;
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
        setOrder(order);
        return this;
    }

    public Group withPhase(Phase phase) {
        setPhase(phase);
        return this;
    }

    public Group withPresences(List<GroupTeamPresence> presences) {
        setPresences(presences);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", this.id)
                .append("name", this.name)
                .append("order", this.order)
                .append("presences", this.presences)
                .append("phase", this.phase)
                .toString();
    }
}
