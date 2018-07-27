package com.corujito.champz.rest.resource;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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
import com.corujito.champz.rest.ParticipantUtils;
import com.corujito.champz.rest.model.Participant;
import com.corujito.champz.rest.service.IParticipantService;

@RunWith(MockitoJUnitRunner.class)
public class ParticipantResourceTest {

    @InjectMocks
    @Autowired
    ParticipantResource participantResource;

    @Mock
    IParticipantService participantService;

    @Before
    public void before() {}

    @Test
    public void testGetParticipant() throws Exception {
        when(participantService.getParticipant("1")).thenReturn(ParticipantUtils.createParticipant("1"));

        Participant participant = participantResource.getParticipant("1");
        assertThat(participant, notNullValue());
    }

    @Test
    public void testAddParticipant() {
        Participant c = ParticipantUtils.createParticipant("1");
        when(participantService.addParticipant(c)).thenReturn(c);

        Participant participant = participantResource.addParticipant(c);
        assertThat(participant, notNullValue());
    }

    @Test
    public void testUpdateParticipant() {
        Participant c = ParticipantUtils.createParticipant("1");
        when(participantService.updateParticipant(c)).thenReturn(c);

        Participant participant = participantResource.updateParticipant(c.getId(), c);
        assertThat(participant, notNullValue());
    }

    @Test
    public void testGetAllParticipants() {
        List<Participant> list =
                Arrays.asList(ParticipantUtils.createParticipant("1"), ParticipantUtils.createParticipant("2"));
        when(participantService.getAllParticipants()).thenReturn(list);

        List<Participant> participants = participantResource.getAllParticipants();
        assertEquals(participants.size(), list.size());
    }

    @Test
    public void testDelete() {
        participantResource.deleteParticipant("1");
        verify(participantService, times(1)).deleteParticipant("1");
    }
}
