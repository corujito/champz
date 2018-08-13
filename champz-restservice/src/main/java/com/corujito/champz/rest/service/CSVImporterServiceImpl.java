package com.corujito.champz.rest.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.model.Group;
import com.corujito.champz.rest.model.GroupTeamPresence;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.model.MatchStatus;
import com.corujito.champz.rest.model.Phase;
import com.corujito.champz.rest.model.Season;
import com.corujito.champz.rest.model.Team;
import com.corujito.champz.rest.model.TeamSeasonParticipant;
import com.corujito.champz.rest.model.User;

@Service
public class CSVImporterServiceImpl implements ICSVImporterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVImporterServiceImpl.class);

    private static final String COLUMN_SEPARATOR = "\t";
    private static final String USUARIO = "USUÁRIO";
    private static final String CAMPEONATO = "CAMPEONATO";
    private static final String TIMES = "TIMES";
    private static final String JOGOS = "JOGOS";

    @Autowired
    IUserService userService;

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

    @Override
    public void importCsv(String filename) throws Exception {
        User user = new User();
        Championship championship = new Championship();
        Season season = new Season();
        Map<String, Team> teamMap = new HashMap<>();
        Map<String, Phase> phaseMap = new HashMap<>();
        Map<String, Group> groupMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linha = null;
            String tipo = "";
            while ((linha = reader.readLine()) != null) {
                linha = linha.trim();
                LOGGER.debug(linha);
                tipo = descobreTipo(tipo, linha);
                if (linha.isEmpty() || tipo.isEmpty() || linha.startsWith(tipo) || linha.startsWith(COLUMN_SEPARATOR)) {
                    continue;
                }
                String[] fields = linha.split(COLUMN_SEPARATOR);
                try {
                    if (tipo.equals(USUARIO)) {
                        if (linha.startsWith("Nome:")) {
                            user.withName(fields[1].trim());
                        } else if (linha.startsWith("Email:")) {
                            user.withEmail(fields[1].trim());
                            User retrieved = userService.getUserByEmail(user.getEmail());
                            if (retrieved == null) {
                                user = userService.addUser(user);
                            } else {
                                user = userService.updateUser(user.withId(retrieved.getId()));
                            }
                        }
                    } else if (tipo.equals(CAMPEONATO)) {
                        championship.withUser(user);
                        if (linha.startsWith("Nome:")) {
                            championship.withName(fields[1].trim());
                        } else if (linha.startsWith("Ano:")) {
                            season.withTitle(fields[1].trim());
                            Championship c = championshipService.getChampionshipByUserIdAndName(user.getId(),
                                    championship.getName());
                            if (c == null) {
                                championship = championshipService.addChampionship(championship);
                            } else {
                                championship = championshipService.updateChampionship(championship.withId(c.getId()));
                            }
                            Season s = seasonService.getSeasonByChampionshipIdAndTitle(championship.getId(),
                                    season.getTitle());
                            if (s == null) {
                                season = seasonService.addSeason(season.withChampionship(championship));
                            } else {
                                season = seasonService
                                        .updateSeason(season.withChampionship(championship).withId(s.getId()));
                            }
                        }
                    } else if (tipo.equals(TIMES)) {
                        if (linha.startsWith("nome") && linha.contains("imagem do logo")) {
                            continue;
                        }
                        Team team = new Team();
                        team.withPopularName(fields[0].trim()).withUser(user);
                        if (fields.length > 1) {
                            team.withSymbolImage(fields[1].trim());
                        }
                        Team t = teamService.getTeamByUserIdAndPopularName(user.getId(), team.getPopularName());
                        if (t == null) {
                            team = teamService.addTeam(team);
                        } else {
                            team = teamService.updateTeam(team.withId(t.getId()));
                        }
                        teamMap.put(team.getPopularName(), team);

                        TeamSeasonParticipant teamSeasonParticipant =
                                new TeamSeasonParticipant().withSeason(season).withTeam(team);
                        TeamSeasonParticipant tsp = teamSeasonParticipantService
                                .getTeamSeasonParticipantBySeasonIdAndTeamId(season.getId(), team.getId());
                        if (tsp == null) {
                            teamSeasonParticipant =
                                    teamSeasonParticipantService.addTeamSeasonParticipant(teamSeasonParticipant);
                        } else {
                            teamSeasonParticipant = teamSeasonParticipantService
                                    .updateTeamSeasonParticipant(teamSeasonParticipant.withId(tsp.getId()));
                        }
                    } else if (tipo.equals(JOGOS)) {
                        if (linha.startsWith("jogo_nro")) {
                            continue;
                        }
                        String homeTeamLabel = fields[4].trim();
                        Team team1 = teamMap.get(homeTeamLabel);
                        String awayTeamLabel = fields[7].trim();
                        Team team2 = teamMap.get(awayTeamLabel);

                        String phaseName = fields[9].trim();
                        Phase phase;
                        if (phaseMap.containsKey(phaseName)) {
                            phase = phaseMap.get(phaseName);
                        } else {
                            phase = new Phase().withName(phaseName).withSeason(season);
                            Phase p = phaseService.getPhaseBySeasonIdAndName(season.getId(), phaseName);
                            if (p == null) {
                                phase = phaseService.addPhase(phase);
                            } else {
                                phase = phaseService.updatePhase(phase.withId(p.getId()));
                            }
                            phaseMap.put(phaseName, phase);
                        }

                        String groupName = fields[10].trim();
                        Group group;
                        boolean update = false;
                        if (groupMap.containsKey(phaseName + groupName)) {
                            group = groupMap.get(phaseName + groupName);
                            List<GroupTeamPresence> presences = group.getPresences();
                            if (team1 != null) {
                                long count = presences.stream().filter(p -> p.getTeam().getId().equals(team1.getId()))
                                        .count();
                                if (count == 0) {
                                    presences.add(new GroupTeamPresence().withTeam(team1));
                                    update = true;
                                }
                            }
                            if (team2 != null) {
                                long count = presences.stream().filter(p -> p.getTeam().getId().equals(team2.getId()))
                                        .count();
                                if (count == 0) {
                                    presences.add(new GroupTeamPresence().withTeam(team2));
                                    update = true;
                                }
                            }
                            if (update) {
                                group = groupService.updateGroup(group);
                                groupMap.put(phaseName + groupName, group);
                            }
                        } else {
                            group = new Group().withName(groupName).withPhase(phase);
                            Group g = groupService.getGroupByPhaseIdAndName(phase.getId(), group.getName());
                            if (g == null) {
                                List<GroupTeamPresence> presences = new ArrayList<>();
                                if (team1 != null) {
                                    presences.add(new GroupTeamPresence().withTeam(team1));
                                }
                                if (team2 != null) {
                                    presences.add(new GroupTeamPresence().withTeam(team2));
                                }
                                group = groupService.addGroup(group.withPresences(presences));
                                groupMap.put(phaseName + groupName, group);
                            } else {
                                List<GroupTeamPresence> ps = g.getPresences();
                                if (team1 != null) {
                                    long count = ps.stream().filter(p -> p.getTeam().getId().equals(team1.getId()))
                                            .count();
                                    if (count == 0) {
                                        ps.add(new GroupTeamPresence().withTeam(team1));
                                        update = true;
                                    }
                                }
                                if (team2 != null) {
                                    long count = ps.stream().filter(p -> p.getTeam().getId().equals(team2.getId()))
                                            .count();
                                    if (count == 0) {
                                        ps.add(new GroupTeamPresence().withTeam(team2));
                                        update = true;
                                    }
                                }
                                group = groupService.updateGroup(group.withPresences(ps).withId(g.getId()));
                                groupMap.put(phaseName + groupName, group);
                            }
                        }

                        int round = Integer.parseInt(fields[8].trim());
                        MatchStatus matchStatus;
                        int homeScore = 0;
                        int awayScore = 0;
                        if (fields[5].trim().equals("") && fields[6].trim().equals("")) {
                            matchStatus = MatchStatus.SCHEDULED;
                        } else {
                            homeScore = Integer.parseInt(fields[5].trim());
                            awayScore = Integer.parseInt(fields[6].trim());
                            matchStatus = MatchStatus.FINISHED;
                        }
                        String locale = fields[3].trim();
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        Date originalDate = df.parse(fields[1].trim() + " " + fields[2].trim());
                        Match match = new Match()
                                .withMatchStatus(matchStatus)
                                .withSeason(season).withPhase(phase).withGroup(group).withRound(round)
                                .withHomeScore(homeScore).withAwayScore(awayScore)
                                .withLocale(locale).withOriginalDate(originalDate).withMatchDate(originalDate);
                        if (team1 != null) {
                            match.withHomeTeam(team1);
                        } else {
                            match.withHomeTeamLabel(homeTeamLabel);
                        }
                        if (team2 != null) {
                            match.withAwayTeam(team2);
                        } else {
                            match.withAwayTeamLabel(awayTeamLabel);
                        }

                        String team1Id = team1 != null ? team1.getId() : null;
                        String team2Id = team2 != null ? team2.getId() : null;
                        Match m = matchService.getMatchBySeasonIdAndPhaseIdAndGroupIdAndHomeTeamIdAndAwayTeamIdAndRound(
                                season.getId(), phase.getId(), group.getId(), team1Id, team2Id,
                                match.getRound());
                        if (m == null) {
                            match = matchService.addMatch(match);
                        } else {
                            match = matchService.updateMatch(match.withId(m.getId()));
                        }
                    }
                } catch (Exception e) {
                    LOGGER.warn("CSV format error for line: " + linha);
                    throw e;
                }
            }
        }
    }

    private static String descobreTipo(String tipo, String linha) {
        if (linha.startsWith(CAMPEONATO)) {
            return CAMPEONATO;
        } else if (linha.startsWith(USUARIO)) {
            return USUARIO;
        } else if (linha.startsWith(JOGOS)) {
            return JOGOS;
        } else if (linha.startsWith(TIMES)) {
            return TIMES;
        } else {
            return tipo;
        }
    }
}
