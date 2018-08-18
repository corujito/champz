package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.ClassificationRow;
import com.corujito.champz.rest.model.ClassificationTable;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.model.MatchStatus;
import com.corujito.champz.rest.model.Team;

@Service
public class ClassificationTableServiceImpl implements IClassificationTableService {

    private static final int WIN_POINTS = 3;
    private static final int LOSE_POINTS = 0;
    private static final int DRAW_POINTS = 1;

    @Override
    public ClassificationTable generateClassificationTable(List<Team> teams, List<Match> matches) {
        Map<String, ClassificationRow> rowsMap = new HashMap<>();
        for (Team team : teams) {
            rowsMap.put(team.getId(), new ClassificationRow().withTeam(team));
            // TODO: set penalty points
        }

        for (Match match : matches) {
            if (MatchStatus.FINISHED.equals(match.getMatchStatus())) {
                Team homeTeam = match.getHomeTeam();
                Team awayTeam = match.getAwayTeam();

                ClassificationRow homeRow = rowsMap.get(homeTeam.getId());
                ClassificationRow awayRow = rowsMap.get(awayTeam.getId());

                homeRow.setNumberMatches(homeRow.getNumberMatches() + 1);
                awayRow.setNumberMatches(awayRow.getNumberMatches() + 1);
                homeRow.setProGoals(homeRow.getProGoals() + match.getHomeScore());
                awayRow.setProGoals(awayRow.getProGoals() + match.getAwayScore());
                homeRow.setAgainstGoals(homeRow.getAgainstGoals() + match.getAwayScore());
                awayRow.setAgainstGoals(awayRow.getAgainstGoals() + match.getHomeScore());

                if (match.getHomeScore() > match.getAwayScore()) {
                    homeRow.setWins(homeRow.getWins() + 1);
                    awayRow.setLosts(awayRow.getLosts() + 1);
                    homeRow.setPoints(homeRow.getPoints() + WIN_POINTS);
                    awayRow.setPoints(awayRow.getPoints() + LOSE_POINTS);
                    homeRow.getMatchesHistory().add(WIN_POINTS);
                    awayRow.getMatchesHistory().add(LOSE_POINTS);
                } else if (match.getHomeScore() < match.getAwayScore()) {
                    awayRow.setWins(awayRow.getWins() + 1);
                    homeRow.setLosts(homeRow.getLosts() + 1);
                    awayRow.setPoints(awayRow.getPoints() + WIN_POINTS);
                    homeRow.setPoints(homeRow.getPoints() + LOSE_POINTS);
                    awayRow.getMatchesHistory().add(WIN_POINTS);
                    homeRow.getMatchesHistory().add(LOSE_POINTS);
                } else {
                    homeRow.setDraws(homeRow.getDraws() + 1);
                    awayRow.setDraws(awayRow.getDraws() + 1);
                    homeRow.setPoints(homeRow.getPoints() + DRAW_POINTS);
                    awayRow.setPoints(awayRow.getPoints() + DRAW_POINTS);
                    homeRow.getMatchesHistory().add(DRAW_POINTS);
                    awayRow.getMatchesHistory().add(DRAW_POINTS);
                }
            }
        }

        List<ClassificationRow> rows = new ArrayList<>(rowsMap.values());
        for (ClassificationRow row : rows) {
            row.setBalanceGoals(row.getProGoals() - row.getAgainstGoals());
            row.setPoints(row.getPoints() + row.getPenaltyPoints());
            if (row.getNumberMatches() > 0) {
                row.setPercent((double) (row.getPoints() * 100) / (row.getNumberMatches() * WIN_POINTS));
            }
        }
        Collections.sort(rows, new ClassificationRowComparator());
        int position = 1;
        for (ClassificationRow row : rows) {
            row.setPosition(position++);
        }

        return new ClassificationTable().withRows(rows);
    }
}


class ClassificationRowComparator implements Comparator<ClassificationRow> {
    private enum Criterios {
        POINTS, WINS, BALANCE, GOALS_PRO, GOALS_AGAINST
    }

    @Override
    public int compare(ClassificationRow r1, ClassificationRow r2) {
        List<Criterios> sortedCriterios = Arrays.asList(
                Criterios.POINTS, Criterios.WINS, Criterios.BALANCE,
                Criterios.GOALS_PRO, Criterios.GOALS_AGAINST);
        for (Criterios criterio : sortedCriterios) {
            if (Criterios.POINTS.equals(criterio)) {
                if (r1.getPoints() > r2.getPoints()) {
                    return -1;
                } else if (r1.getPoints() < r2.getPoints()) {
                    return 1;
                }
            } else if (Criterios.WINS.equals(criterio)) {
                if (r1.getWins() > r2.getWins()) {
                    return -1;
                } else if (r1.getWins() < r2.getWins()) {
                    return 1;
                }
            } else if (Criterios.BALANCE.equals(criterio)) {
                if (r1.getBalanceGoals() > r2.getBalanceGoals()) {
                    return -1;
                } else if (r1.getBalanceGoals() < r2.getBalanceGoals()) {
                    return 1;
                }
            } else if (Criterios.GOALS_PRO.equals(criterio)) {
                if (r1.getProGoals() > r2.getProGoals()) {
                    return -1;
                } else if (r1.getProGoals() < r2.getProGoals()) {
                    return 1;
                }
            } else if (Criterios.GOALS_AGAINST.equals(criterio)) {
                if (r1.getAgainstGoals() > r2.getAgainstGoals()) {
                    return -1;
                } else if (r1.getAgainstGoals() < r2.getAgainstGoals()) {
                    return 1;
                }
            }
        }
        return r1.getTeam().getPopularName().compareTo(r2.getTeam().getPopularName());
    }
}
