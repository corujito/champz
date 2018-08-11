package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.model.ClassificationTable;
import com.corujito.champz.rest.model.Group;
import com.corujito.champz.rest.model.GroupTeamPresence;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.model.Phase;
import com.corujito.champz.rest.model.Season;
import com.corujito.champz.rest.model.SeasonSummary;
import com.corujito.champz.rest.model.Team;
import com.corujito.champz.rest.model.TeamSeasonParticipant;

@Service
public class SeasonSummaryServiceImpl implements ISeasonSummaryService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ISeasonService seasonService;

    @Autowired
    private IChampionshipService championshipService;

    @Autowired
    private ITeamService teamService;

    @Autowired
    private ITeamSeasonParticipantService teamSeasonParticipantService;

    @Autowired
    private IPhaseService phaseService;

    @Autowired
    private IGroupService groupService;

    @Autowired
    private IMatchService matchService;

    @Autowired
    private IClassificationTableService classificationTableService;

    Map<String, Team> teamMap;

    @Override
    public SeasonSummary getSeasonSummary(String id) {
        Season season = seasonService.getSeason(id);

        Championship championship = championshipService.getChampionship(season.getChampionship().getId());
        season.withChampionship(championship);

        teamMap = new HashMap<>();
        List<TeamSeasonParticipant> teamSeasonParticipants =
                teamSeasonParticipantService.getTeamSeasonParticipantsBySeasonId(season.getId());
        for (TeamSeasonParticipant teamSeasonParticipant : teamSeasonParticipants) {
            Team team = teamService.getTeam(teamSeasonParticipant.getTeam().getId());
            teamMap.put(team.getId(), team);
            teamSeasonParticipant.withTeam(team);
        }
        season.withParticipants(teamSeasonParticipants);

        List<Match> matches = matchService.getMatchesBySeasonId(season.getId());
        for (Match match : matches) {
            if (match.getHomeTeam() != null) {
                match.withHomeTeam(teamMap.get(match.getHomeTeam().getId()));
            }
            if (match.getHomeTeam() != null) {
                match.withAwayTeam(teamMap.get(match.getAwayTeam().getId()));
            }
        }

        List<Phase> phases = phaseService.getPhasesBySeasonId(season.getId());
        for (Phase phase : phases) {
            List<Group> groups = groupService.getGroupsByPhaseId(phase.getId());
            for (Group group : groups) {
                List<Team> groupTeams = new ArrayList<>();
                if (group.getPresences() != null) {
                    for (GroupTeamPresence presence : group.getPresences()) {
                        Team team = teamMap.get(presence.getTeam().getId());
                        presence.withTeam(team);
                        groupTeams.add(team);
                    }
                }

                List<Match> groupMatches = matches.stream().filter(m -> group.getId().equals(m.getGroup().getId()))
                        .collect(Collectors.toList());
                ClassificationTable classificationTable =
                        classificationTableService.generateClassificationTable(groupTeams, groupMatches);
                group.withClassificationTable(classificationTable).withMatches(groupMatches);
            }
            phase.withGroups(groups);
        }
        season.withPhases(phases);

        return new SeasonSummary().withSeason(season).withTeams(teamMap);
    }
}
