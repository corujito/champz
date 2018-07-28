package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.TeamSeasonParticipant;

public interface ITeamSeasonParticipantService {

    TeamSeasonParticipant getTeamSeasonParticipant(String id);

    List<TeamSeasonParticipant> getAllTeamSeasonParticipant();

    TeamSeasonParticipant addTeamSeasonParticipant(TeamSeasonParticipant teamSeasonParticipant);

    TeamSeasonParticipant updateTeamSeasonParticipant(TeamSeasonParticipant teamSeasonParticipant);

    void deleteTeamSeasonParticipant(String id);
}
