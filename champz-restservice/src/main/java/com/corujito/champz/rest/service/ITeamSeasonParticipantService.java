package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.TeamSeasonParticipant;

public interface ITeamSeasonParticipantService {

    TeamSeasonParticipant getTeamSeasonParticipant(String id);

    TeamSeasonParticipant getTeamSeasonParticipantBySeasonIdAndTeamId(String seasonId, String teamId);

    List<TeamSeasonParticipant> getAllTeamSeasonParticipant();

    List<TeamSeasonParticipant> getTeamSeasonParticipantsBySeasonId(String seasonId);

    TeamSeasonParticipant addTeamSeasonParticipant(TeamSeasonParticipant teamSeasonParticipant);

    TeamSeasonParticipant updateTeamSeasonParticipant(TeamSeasonParticipant teamSeasonParticipant);

    void deleteTeamSeasonParticipant(String id);
}
