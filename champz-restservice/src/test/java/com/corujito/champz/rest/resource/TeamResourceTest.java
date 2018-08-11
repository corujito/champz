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
import com.corujito.champz.rest.TeamUtils;
import com.corujito.champz.rest.model.Team;
import com.corujito.champz.rest.service.ITeamService;

@RunWith(MockitoJUnitRunner.class)
public class TeamResourceTest {

    @InjectMocks
    @Autowired
    TeamResource teamResource;

    @Mock
    ITeamService teamService;

    @Before
    public void before() {}

    @Test
    public void testGetTeam() throws Exception {
        Team c = TeamUtils.createTeam("1");
        when(teamService.getTeam("1")).thenReturn(c);

        Team team = teamResource.getTeam("1");
        TeamUtils.assertObjects(team, c);
    }

    @Test
    public void testAddTeam() {
        Team c = TeamUtils.createTeam("1");
        when(teamService.addTeam(c)).thenReturn(c);

        Team team = teamResource.addTeam(c);
        TeamUtils.assertObjects(team, c);
    }

    @Test
    public void testUpdateTeam() {
        Team c = TeamUtils.createTeam("1");
        when(teamService.updateTeam(c)).thenReturn(c);

        Team team = teamResource.updateTeam(c.getId(), c);
        TeamUtils.assertObjects(team, c);
    }

    @Test
    public void testGetAllTeams() {
        List<Team> list =
                Arrays.asList(TeamUtils.createTeam("1"), TeamUtils.createTeam("2"));
        when(teamService.getAllTeams()).thenReturn(list);

        List<Team> teams = teamResource.getAllTeams();
        assertEquals(teams.size(), list.size());
    }

    @Test
    public void testDelete() {
        teamResource.deleteTeam("1");
        verify(teamService, times(1)).deleteTeam("1");
    }
}
