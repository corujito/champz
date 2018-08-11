package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.repository.IMatchRepository;
import com.corujito.champz.rest.repository.entity.MatchEntity;

@Service
public class MatchServiceImpl implements IMatchService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IMatchRepository repository;

    @Override
    public Match getMatch(String id) {
        Optional<MatchEntity> opt = repository.findById(id);
        return opt.map(m -> modelMapper.map(m, Match.class)).orElse(null);
    }

    @Override
    public List<Match> getAllMatches() {
        List<Match> matchs = new ArrayList<>();
        List<MatchEntity> entities = repository.findAll();
        for (MatchEntity entity : entities) {
            matchs.add(modelMapper.map(entity, Match.class));
        }
        return matchs;
    }

    @Override
    public List<Match> getMatchesBySeasonId(String seasonId) {
        List<Match> matchs = new ArrayList<>();
        List<MatchEntity> entities = repository.findBySeasonId(seasonId);
        for (MatchEntity entity : entities) {
            matchs.add(modelMapper.map(entity, Match.class));
        }
        return matchs;
    }

    @Override
    public Match addMatch(Match match) {
        MatchEntity entity = repository.save(modelMapper.map(match, MatchEntity.class));
        return modelMapper.map(entity, Match.class);
    }

    @Override
    public Match updateMatch(Match match) {
        return addMatch(match);
    }

    @Override
    public void deleteMatch(String id) {
        repository.deleteById(id);
    }
}
