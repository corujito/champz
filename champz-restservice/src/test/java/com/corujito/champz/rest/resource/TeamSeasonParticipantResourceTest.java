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
import com.corujito.champz.rest.TeamSeasonParticipantUtils;
import com.corujito.champz.rest.model.TeamSeasonParticipant;
import com.corujito.champz.rest.service.ITeamSeasonParticipantService;

@RunWith(MockitoJUnitRunner.class)
public class TeamSeasonParticipantResourceTest {

    @InjectMocks
    @Autowired
    TeamSeasonParticipantResource participantResource;

    @Mock
    ITeamSeasonParticipantService participantService;

    @Before
    public void before() {}

    @Test
    public void testGetTeamSeasonParticipant() throws Exception {
        TeamSeasonParticipant c = TeamSeasonParticipantUtils.createTeamSeasonParticipant("1");
        when(participantService.getTeamSeasonParticipant("1"))
                .thenReturn(c);

        TeamSeasonParticipant participant = participantResource.getTeamSeasonParticipant("1");
        TeamSeasonParticipantUtils.assertObjects(participant, c);
    }

    @Test
    public void testAddTeamSeasonParticipant() {
        TeamSeasonParticipant c = TeamSeasonParticipantUtils.createTeamSeasonParticipant("1");
        when(participantService.addTeamSeasonParticipant(c)).thenReturn(c);

        TeamSeasonParticipant participant = participantResource.addTeamSeasonParticipant(c);
        TeamSeasonParticipantUtils.assertObjects(participant, c);
    }

    @Test
    public void testUpdateTeamSeasonParticipant() {
        TeamSeasonParticipant c = TeamSeasonParticipantUtils.createTeamSeasonParticipant("1");
        when(participantService.updateTeamSeasonParticipant(c)).thenReturn(c);

        TeamSeasonParticipant participant = participantResource.updateTeamSeasonParticipant(c.getId(), c);
        TeamSeasonParticipantUtils.assertObjects(participant, c);
    }

    @Test
    public void testGetAllTeamSeasonParticipants() {
        List<TeamSeasonParticipant> list =
                Arrays.asList(TeamSeasonParticipantUtils.createTeamSeasonParticipant("1"),
                        TeamSeasonParticipantUtils.createTeamSeasonParticipant("2"));
        when(participantService.getAllTeamSeasonParticipant()).thenReturn(list);

        List<TeamSeasonParticipant> participants = participantResource.getAllTeamSeasonParticipants();
        assertEquals(participants.size(), list.size());
    }

    @Test
    public void testDelete() {
        participantResource.deleteTeamSeasonParticipant("1");
        verify(participantService, times(1)).deleteTeamSeasonParticipant("1");
    }
}
