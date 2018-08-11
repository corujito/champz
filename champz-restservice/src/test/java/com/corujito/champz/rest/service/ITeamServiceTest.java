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
import com.corujito.champz.rest.TeamUtils;
import com.corujito.champz.rest.model.Team;
import com.corujito.champz.rest.repository.ITeamRepository;
import com.corujito.champz.rest.repository.entity.TeamEntity;

@RunWith(MockitoJUnitRunner.class)
public class ITeamServiceTest {

    @InjectMocks
    @Autowired
    TeamServiceImpl teamService;

    @Mock
    ITeamRepository repository;

    @Test
    public void testGetTeam() throws Exception {
        Optional<TeamEntity> x = Optional.of(TeamUtils.createTeamEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        Team team = teamService.getTeam("1");
        TeamUtils.assertObjects(x.get(), team);
    }

    @Test
    public void testAddTeam() {
        TeamEntity c = TeamUtils.createTeamEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Team team = teamService.addTeam(new Team());
        TeamUtils.assertObjects(c, team);
    }

    @Test
    public void testUpdateTeam() {
        TeamEntity c = TeamUtils.createTeamEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Team team = teamService.updateTeam(new Team());
        TeamUtils.assertObjects(c, team);
    }

    @Test
    public void testGetAllTeams() {
        List<TeamEntity> entities =
                Arrays.asList(TeamUtils.createTeamEntity("1"), TeamUtils.createTeamEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<Team> teams = teamService.getAllTeams();
        assertEquals(teams.size(), entities.size());
    }

    @Test
    public void testDelete() {
        teamService.deleteTeam("1");
        verify(repository, times(1)).deleteById("1");
    }
}
