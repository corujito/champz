package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Team;
import com.corujito.champz.rest.repository.ITeamRepository;
import com.corujito.champz.rest.repository.entity.TeamEntity;

@Service
public class TeamServiceImpl implements ITeamService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ITeamRepository repository;

    @Override
    public Team getTeam(String id) {
        Optional<TeamEntity> opt = repository.findById(id);
        return opt.map(t -> modelMapper.map(t, Team.class)).orElse(null);
    }

    @Override
    public Team getTeamByUserIdAndPopularName(String userId, String popularName) {
        Optional<TeamEntity> opt = repository.findByUserIdAndPopularName(userId, popularName);
        return opt.map(t -> modelMapper.map(t, Team.class)).orElse(null);
    }

    @Override
    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        List<TeamEntity> entities = repository.findAll();
        for (TeamEntity entity : entities) {
            teams.add(modelMapper.map(entity, Team.class));
        }
        return teams;
    }

    @Override
    public Team addTeam(Team team) {
        TeamEntity entity = repository.save(modelMapper.map(team, TeamEntity.class));
        return modelMapper.map(entity, Team.class);
    }

    @Override
    public Team updateTeam(Team team) {
        return addTeam(team);
    }

    @Override
    public void deleteTeam(String id) {
        repository.deleteById(id);
    }
}
