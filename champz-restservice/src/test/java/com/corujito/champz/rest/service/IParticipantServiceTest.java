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
import com.corujito.champz.rest.ParticipantUtils;
import com.corujito.champz.rest.model.Participant;
import com.corujito.champz.rest.repository.IParticipantRepository;
import com.corujito.champz.rest.repository.entity.ParticipantEntity;

@RunWith(MockitoJUnitRunner.class)
public class IParticipantServiceTest {

    @InjectMocks
    @Autowired
    ParticipantServiceImpl participantService;

    @Mock
    IParticipantRepository repository;

    @Test
    public void testGetParticipant() throws Exception {
        Optional<ParticipantEntity> x = Optional.of(ParticipantUtils.createParticipantEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        Participant participant = participantService.getParticipant("1");
        assertThat(participant, notNullValue());
    }

    @Test
    public void testAddParticipant() {
        ParticipantEntity c = ParticipantUtils.createParticipantEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Participant participant = participantService.addParticipant(new Participant());
        assertThat(participant, notNullValue());
    }

    @Test
    public void testUpdateParticipant() {
        ParticipantEntity c = ParticipantUtils.createParticipantEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Participant participant = participantService.updateParticipant(new Participant());
        assertThat(participant, notNullValue());
    }

    @Test
    public void testGetAllParticipants() {
        List<ParticipantEntity> entities = Arrays.asList(ParticipantUtils.createParticipantEntity("1"),
                ParticipantUtils.createParticipantEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<Participant> participants = participantService.getAllParticipants();
        assertEquals(participants.size(), entities.size());
    }

    @Test
    public void testDelete() {
        participantService.deleteParticipant("1");
        verify(repository, times(1)).deleteById("1");
    }
}
