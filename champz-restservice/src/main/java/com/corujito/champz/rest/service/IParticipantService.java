package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.Participant;

public interface IParticipantService {

    Participant getParticipant(String id);

    List<Participant> getAllParticipants();

    Participant addParticipant(Participant participant);

    Participant updateParticipant(Participant participant);

    void deleteParticipant(String id);
}
