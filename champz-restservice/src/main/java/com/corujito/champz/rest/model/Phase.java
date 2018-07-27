package com.corujito.champz.rest.model;

public class Phase extends BaseDomain {

    private String name;
    private int upZone;
    private int downZone;
    private boolean isMain;
    private int currentRound;
    private Season season;
    private int repetitions;

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
}
