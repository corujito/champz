package com.corujito.champz.rest.model;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Phase {

    @NotNull(groups = {Existing.class, Match.New.class, Match.Existing.class, Group.New.class, Group.Existing.class})
    @Null(groups = New.class)
    private String id;
    private int order;
    private String name;
    private int upZone;
    private int downZone;
    private boolean isMain;
    private int currentRound;
    private int repetitions;
    private PhaseType type;

    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Season season;
    private List<Group> groups;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean isMain) {
        this.isMain = isMain;
    }

    public int getUpZone() {
        return upZone;
    }

    public void setUpZone(int upZone) {
        this.upZone = upZone;
    }

    public int getDownZone() {
        return downZone;
    }

    public void setDownZone(int downZone) {
        this.downZone = downZone;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public PhaseType getType() {
        return type;
    }

    public void setType(PhaseType type) {
        this.type = type;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Phase withId(String id) {
        setId(id);
        return this;
    }

    public Phase withName(String name) {
        setName(name);
        return this;
    }

    public Phase withUpZone(int upZone) {
        setUpZone(upZone);
        return this;
    }

    public Phase withDownZone(int downZone) {
        setDownZone(downZone);
        return this;
    }

    public Phase withMain(boolean isMain) {
        setMain(isMain);
        return this;
    }

    public Phase withCurrentRound(int currentRound) {
        setCurrentRound(currentRound);
        return this;
    }

    public Phase withSeason(Season season) {
        setSeason(season);
        return this;
    }

    public Phase withRepetitions(int repetitions) {
        setRepetitions(repetitions);
        return this;
    }

    public Phase withGroups(List<Group> groups) {
        setGroups(groups);
        return this;
    }

    public Phase withOrder(int order) {
        setOrder(order);
        return this;
    }

    public Phase withType(PhaseType type) {
        setType(type);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", this.id)
                .append("currentRound", this.currentRound)
                .append("downZone", this.downZone)
                .append("isMain", this.isMain)
                .append("order", this.order)
                .append("repetitions", this.repetitions)
                .append("upZone", this.upZone)
                .toString();
    }
}
