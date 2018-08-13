package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.repository.IChampionshipRepository;
import com.corujito.champz.rest.repository.entity.ChampionshipEntity;

@Service
public class ChampionshipServiceImpl implements IChampionshipService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IChampionshipRepository repository;

    @Override
    public Championship getChampionship(String id) {
        Optional<ChampionshipEntity> opt = repository.findById(id);
        return opt.map(c -> modelMapper.map(c, Championship.class)).orElse(null);
    }

    @Override
    public Championship getChampionshipByUserIdAndName(String userId, String name) {
        Optional<ChampionshipEntity> opt = repository.findByUserIdAndName(userId, name);
        return opt.map(c -> modelMapper.map(c, Championship.class)).orElse(null);
    }

    @Override
    public List<Championship> getAllChampionships() {
        List<Championship> championships = new ArrayList<>();
        List<ChampionshipEntity> entities = repository.findAll();
        for (ChampionshipEntity entity : entities) {
            championships.add(modelMapper.map(entity, Championship.class));
        }
        return championships;
    }

    @Override
    public Championship addChampionship(Championship championship) {
        ChampionshipEntity entity = repository.save(modelMapper.map(championship, ChampionshipEntity.class));
        return modelMapper.map(entity, Championship.class);
    }

    @Override
    public Championship updateChampionship(Championship championship) {
        return addChampionship(championship);
    }

    @Override
    public void deleteChampionship(String id) {
        repository.deleteById(id);
    }
}
