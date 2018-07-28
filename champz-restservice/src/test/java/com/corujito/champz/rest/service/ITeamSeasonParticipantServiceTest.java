package com.corujito.champz.rest.service;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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
import com.corujito.champz.rest.TeamSeasonParticipantUtils;
import com.corujito.champz.rest.model.TeamSeasonParticipant;
import com.corujito.champz.rest.repository.ITeamSeasonParticipantRepository;
import com.corujito.champz.rest.repository.entity.TeamSeasonParticipantEntity;

@RunWith(MockitoJUnitRunner.class)
public class ITeamSeasonParticipantServiceTest {

    @InjectMocks
    @Autowired
    TeamSeasonParticipantServiceImpl teamSeasonParticipantService;

    @Mock
    ITeamSeasonParticipantRepository repository;

    @Test
    public void testGetTeamSeasonParticipant() throws Exception {
        Optional<TeamSeasonParticipantEntity> x =
                Optional.of(TeamSeasonParticipantUtils.createTeamSeasonParticipantEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        TeamSeasonParticipant participant = teamSeasonParticipantService.getTeamSeasonParticipant("1");
        assertThat(participant, notNullValue());
    }

    @Test
    public void testAddTeamSeasonParticipant() {
        TeamSeasonParticipantEntity c = TeamSeasonParticipantUtils.createTeamSeasonParticipantEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        TeamSeasonParticipant participant =
                teamSeasonParticipantService.addTeamSeasonParticipant(new TeamSeasonParticipant());
        assertThat(participant, notNullValue());
    }

    @Test
    public void testUpdateTeamSeasonParticipant() {
        TeamSeasonParticipantEntity c = TeamSeasonParticipantUtils.createTeamSeasonParticipantEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        TeamSeasonParticipant participant =
                teamSeasonParticipantService.updateTeamSeasonParticipant(new TeamSeasonParticipant());
        assertThat(participant, notNullValue());
    }

    @Test
    public void testGetAllTeamSeasonParticipants() {
        List<TeamSeasonParticipantEntity> entities =
                Arrays.asList(TeamSeasonParticipantUtils.createTeamSeasonParticipantEntity("1"),
                        TeamSeasonParticipantUtils.createTeamSeasonParticipantEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<TeamSeasonParticipant> participants = teamSeasonParticipantService.getAllTeamSeasonParticipant();
        assertEquals(participants.size(), entities.size());
    }

    @Test
    public void testDelete() {
        teamSeasonParticipantService.deleteTeamSeasonParticipant("1");
        verify(repository, times(1)).deleteById("1");
    }
}
