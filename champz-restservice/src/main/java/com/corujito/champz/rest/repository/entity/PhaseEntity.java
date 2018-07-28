package com.corujito.champz.rest.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import com.corujito.champz.rest.model.PhaseType;

@Document(collection = "phases")
public class PhaseEntity extends BaseEntity {

    private int order;
    private String name;
    private int upZone;
    private int downZone;
    private boolean isMain;
    private int currentRound;
    private int repetitions;
    private PhaseType type;

    private String seasonId;

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

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
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

    public PhaseEntity withId(String id) {
        setId(id);
        return this;
    }

    public PhaseEntity withName(String name) {
        setName(name);
        return this;
    }

    public PhaseEntity withUpZone(int upZone) {
        setUpZone(upZone);
        return this;
    }

    public PhaseEntity withDownZone(int downZone) {
        setDownZone(downZone);
        return this;
    }

    public PhaseEntity withMain(boolean isMain) {
        setMain(isMain);
        return this;
    }

    public PhaseEntity withCurrentRound(int currentRound) {
        setCurrentRound(currentRound);
        return this;
    }

    public PhaseEntity withSeasonId(String seasonId) {
        setSeasonId(seasonId);
        return this;
    }

    public PhaseEntity withRepetitions(int repetitions) {
        setRepetitions(repetitions);
        return this;
    }

    public PhaseEntity withOrder(int order) {
        setOrder(order);
        return this;
    }

    public PhaseEntity withType(PhaseType type) {
        setType(type);
        return this;
    }
}
