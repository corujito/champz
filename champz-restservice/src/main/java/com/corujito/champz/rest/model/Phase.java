package com.corujito.champz.rest.model;

import java.util.List;

public class Phase extends BaseDomain {

    private int order;
    private String name;
    private int upZone;
    private int downZone;
    private boolean isMain;
    private int currentRound;
    private int repetitions;
    private PhaseType type;

    private Season season;
    private List<Group> groups;

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
}
