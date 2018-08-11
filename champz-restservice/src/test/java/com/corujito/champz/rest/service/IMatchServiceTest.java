package com.corujito.champz.rest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.corujito.champz.rest.MatchUtils;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.repository.IMatchRepository;
import com.corujito.champz.rest.repository.entity.MatchEntity;

@RunWith(MockitoJUnitRunner.class)
public class IMatchServiceTest {

    @InjectMocks
    @Autowired
    MatchServiceImpl matchService;

    @Mock
    IMatchRepository repository;

    @Test
    public void testGetMatch() throws Exception {
        Optional<MatchEntity> x = Optional.of(MatchUtils.createMatchEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        Match match = matchService.getMatch("1");
        MatchUtils.assertObjects(x.get(), match);
    }

    @Test
    public void testAddMatch() {
        MatchEntity c = MatchUtils.createMatchEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Match match = matchService.addMatch(new Match());
        MatchUtils.assertObjects(c, match);
    }

    @Test
    public void testUpdateMatch() {
        MatchEntity c = MatchUtils.createMatchEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Match match = matchService.updateMatch(new Match());
        MatchUtils.assertObjects(c, match);
    }

    @Test
    public void testGetAllMatches() {
        List<MatchEntity> entities =
                Arrays.asList(MatchUtils.createMatchEntity("1"), MatchUtils.createMatchEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<Match> matchs = matchService.getAllMatches();
        assertEquals(matchs.size(), entities.size());
    }

    @Test
    public void testGetMatchesBySeasonId() {
        String seasonId = "seasonId";
        List<MatchEntity> entities =
                Arrays.asList(MatchUtils.createMatchEntity("1").withSeasonId(seasonId),
                        MatchUtils.createMatchEntity("2").withSeasonId(seasonId));
        when(repository.findBySeasonId(seasonId)).thenReturn(entities);

        List<Match> matchs = matchService.getMatchesBySeasonId(seasonId);
        assertEquals(matchs.size(), entities.size());
    }

    @Test
    public void testDelete() {
        matchService.deleteMatch("1");
        verify(repository, times(1)).deleteById("1");
    }
}
