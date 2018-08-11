package com.corujito.champz.rest.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.corujito.champz.rest.MatchUtils;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.service.IMatchService;

@RunWith(MockitoJUnitRunner.class)
public class MatchResourceTest {

    @InjectMocks
    @Autowired
    MatchResource matchResource;

    @Mock
    IMatchService matchService;

    @Before
    public void before() {}

    @Test
    public void testGetMatch() throws Exception {
        Match c = MatchUtils.createMatch("1");
        when(matchService.getMatch("1")).thenReturn(c);

        Match match = matchResource.getMatch("1");
        MatchUtils.assertObjects(match, c);
    }

    @Test
    public void testAddMatch() {
        Match c = MatchUtils.createMatch("1");
        when(matchService.addMatch(c)).thenReturn(c);

        Match match = matchResource.addMatch(c);
        MatchUtils.assertObjects(match, c);
    }

    @Test
    public void testUpdateMatch() {
        Match c = MatchUtils.createMatch("1");
        when(matchService.updateMatch(c)).thenReturn(c);

        Match match = matchResource.updateMatch(c.getId(), c);
        MatchUtils.assertObjects(match, c);
    }

    @Test
    public void testGetAllMatchs() {
        List<Match> list =
                Arrays.asList(MatchUtils.createMatch("1"), MatchUtils.createMatch("2"));
        when(matchService.getAllMatches()).thenReturn(list);

        List<Match> matchs = matchResource.getAllMatchs();
        assertEquals(matchs.size(), list.size());
    }

    @Test
    public void testDelete() {
        matchResource.deleteMatch("1");
        verify(matchService, times(1)).deleteMatch("1");
    }
}
