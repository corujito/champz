package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Participant;
import com.corujito.champz.rest.repository.IParticipantRepository;
import com.corujito.champz.rest.repository.entity.ParticipantEntity;

@Service
public class ParticipantServiceImpl implements IParticipantService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IParticipantRepository repository;

    @Override
    public Participant getParticipant(String id) {
        Optional<ParticipantEntity> opt = repository.findById(id);
        return opt.map(c -> modelMapper.map(c, Participant.class)).orElse(null);
    }

    @Override
    public List<Participant> getAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        List<ParticipantEntity> entities = repository.findAll();
        for (ParticipantEntity entity : entities) {
            participants.add(modelMapper.map(entity, Participant.class));
        }
        return participants;
    }

    @Override
    public Participant addParticipant(Participant participant) {
        ParticipantEntity entity = repository.save(modelMapper.map(participant, ParticipantEntity.class));
        return modelMapper.map(entity, Participant.class);
    }

    @Override
    public Participant updateParticipant(Participant participant) {
        return addParticipant(participant);
    }

    @Override
    public void deleteParticipant(String id) {
        repository.deleteById(id);
    }
}
