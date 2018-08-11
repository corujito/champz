package com.corujito.champz.rest.service;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.corujito.champz.rest.model.ClassificationRow;
import com.corujito.champz.rest.model.ClassificationTable;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.model.MatchStatus;
import com.corujito.champz.rest.model.Team;

public class IClassificationTableServiceTest {

    IClassificationTableService service = new ClassificationTableServiceImpl();

    @Test
    public void test() {
        Team time1 = new Team().withId("1").withName("Palmeiras");
        Team time2 = new Team().withId("2").withName("Corinthians");
        Team time3 = new Team().withId("3").withName("São Paulo");
        Team time4 = new Team().withId("4").withName("Santos");

        Match jogo1 = new Match().withHomeTeam(time1).withAwayTeam(time2).withMatchStatus(MatchStatus.FINISHED)
                .withRound(1).withHomeScore(1).withAwayScore(0);
        Match jogo2 = new Match().withHomeTeam(time3).withAwayTeam(time4).withMatchStatus(MatchStatus.FINISHED)
                .withRound(1).withHomeScore(2).withAwayScore(0);
        Match jogo3 = new Match().withHomeTeam(time1).withAwayTeam(time3).withMatchStatus(MatchStatus.FINISHED)
                .withRound(2).withHomeScore(1).withAwayScore(0);
        Match jogo4 = new Match().withHomeTeam(time2).withAwayTeam(time4).withMatchStatus(MatchStatus.FINISHED)
                .withRound(2).withHomeScore(1).withAwayScore(1);
        Match jogo5 = new Match().withHomeTeam(time1).withAwayTeam(time4).withMatchStatus(MatchStatus.SCHEDULED)
                .withRound(3).withHomeScore(1).withAwayScore(0);
        Match jogo6 = new Match().withHomeTeam(time2).withAwayTeam(time3).withMatchStatus(MatchStatus.SCHEDULED)
                .withRound(3).withHomeScore(1).withAwayScore(0);

        List<Team> teams = Arrays.asList(time1, time2, time3, time4);
        List<Match> matches = Arrays.asList(jogo1, jogo2, jogo3, jogo4, jogo5, jogo6);
        ClassificationTable table = service.generateClassificationTable(teams, matches);
        for (ClassificationRow row : table.getRows()) {
            System.out.println(row);
        }
        // TODO asserts
    }

}
