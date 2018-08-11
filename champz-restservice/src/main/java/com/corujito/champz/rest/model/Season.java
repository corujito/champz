package com.corujito.champz.rest.model;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Season {

    @NotNull(groups = {Existing.class, TeamSeasonParticipant.New.class, TeamSeasonParticipant.Existing.class,
            Match.New.class, Match.Existing.class, Phase.New.class, Phase.Existing.class, PlayerInscription.New.class,
            PlayerInscription.Existing.class})
    @Null(groups = New.class)
    private String id;
    @NotNull
    @NotBlank
    private String title;
    private String regulation;

    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Championship championship;
    private List<TeamSeasonParticipant> participants;
    private List<PlayerInscription> playerInscriptions;
    private List<Phase> phases;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegulation() {
        return regulation;
    }

    public void setRegulation(String regulation) {
        this.regulation = regulation;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public List<TeamSeasonParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<TeamSeasonParticipant> participants) {
        this.participants = participants;
    }

    public List<PlayerInscription> getPlayerInscriptions() {
        return playerInscriptions;
    }

    public void setPlayerInscriptions(List<PlayerInscription> playerInscriptions) {
        this.playerInscriptions = playerInscriptions;
    }

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    public Season withId(String id) {
        setId(id);
        return this;
    }

    public Season withPhases(List<Phase> phases) {
        setPhases(phases);
        return this;
    }

    public Season withPlayerInscriptions(List<PlayerInscription> playerInscriptions) {
        setPlayerInscriptions(playerInscriptions);
        return this;
    }

    public Season withTitle(String title) {
        setTitle(title);
        return this;
    }

    public Season withRegulation(String regulation) {
        setRegulation(regulation);
        return this;
    }

    public Season withChampionship(Championship championship) {
        setChampionship(championship);
        return this;
    }

    public Season withParticipants(List<TeamSeasonParticipant> participants) {
        setParticipants(participants);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", this.id)
                .append("title", this.title)
                .append("regulation", this.regulation)
                .append("championship", this.championship)
                .append("phases", this.phases)
                .append("playerInscriptions", this.playerInscriptions)
                .append("participants", this.participants)
                .toString();
    }
}
