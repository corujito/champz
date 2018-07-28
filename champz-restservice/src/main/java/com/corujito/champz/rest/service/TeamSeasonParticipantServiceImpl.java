package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.TeamSeasonParticipant;
import com.corujito.champz.rest.repository.ITeamSeasonParticipantRepository;
import com.corujito.champz.rest.repository.entity.TeamSeasonParticipantEntity;

@Service
public class TeamSeasonParticipantServiceImpl implements ITeamSeasonParticipantService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ITeamSeasonParticipantRepository repository;

    @Override
    public TeamSeasonParticipant getTeamSeasonParticipant(String id) {
        Optional<TeamSeasonParticipantEntity> opt = repository.findById(id);
        return opt.map(c -> modelMapper.map(c, TeamSeasonParticipant.class)).orElse(null);
    }

    @Override
    public List<TeamSeasonParticipant> getAllTeamSeasonParticipant() {
        List<TeamSeasonParticipant> teamSeasonParticipants = new ArrayList<>();
        List<TeamSeasonParticipantEntity> entities = repository.findAll();
        for (TeamSeasonParticipantEntity entity : entities) {
            teamSeasonParticipants.add(modelMapper.map(entity, TeamSeasonParticipant.class));
        }
        return teamSeasonParticipants;
    }

    @Override
    public TeamSeasonParticipant addTeamSeasonParticipant(TeamSeasonParticipant teamSeasonParticipant) {
        TeamSeasonParticipantEntity entity =
                repository.save(modelMapper.map(teamSeasonParticipant, TeamSeasonParticipantEntity.class));
        return modelMapper.map(entity, TeamSeasonParticipant.class);
    }

    @Override
    public TeamSeasonParticipant updateTeamSeasonParticipant(TeamSeasonParticipant teamSeasonParticipant) {
        return addTeamSeasonParticipant(teamSeasonParticipant);
    }

    @Override
    public void deleteTeamSeasonParticipant(String id) {
        repository.deleteById(id);
    }
}
