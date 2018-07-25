package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.repository.IChampionshipRepository;
import com.corujito.champz.rest.repository.entity.ChampionshipEntity;

@Service
public class ChampionshipServiceImpl implements IChampionshipService {

    @Autowired
    private IChampionshipRepository repository;

    @Override
    public Championship getChampionship(String id) {
        Optional<ChampionshipEntity> opt = repository.findById(id);
        return opt.map(entity -> mapChampionship(entity)).orElse(null);
    }

    @Override
    public List<Championship> getAllChampionships() {
        List<Championship> championships = new ArrayList<>();
        List<ChampionshipEntity> entities = repository.findAll();
        for (ChampionshipEntity entity : entities) {
            championships.add(mapChampionship(entity));
        }
        return championships;
    }

    @Override
    public Championship addChampionship(Championship championship) {
        ChampionshipEntity entity = repository.save(mapChampionship(championship));
        return mapChampionship(entity);
    }

    @Override
    public Championship updateChampionship(Championship championship) {
        return addChampionship(championship);
    }

    @Override
    public void deleteChampionship(String id) {
        repository.deleteById(id);
    }

    private Championship mapChampionship(ChampionshipEntity entity) {
        Championship championship = new Championship();
        championship.setId(entity.getId());
        championship.setDescription(entity.getDescription());
        championship.setName(entity.getName());
        return championship;
    }

    private ChampionshipEntity mapChampionship(Championship object) {
        ChampionshipEntity entity = new ChampionshipEntity();
        entity.setId(object.getId());
        entity.setDescription(object.getDescription());
        entity.setName(object.getName());
        return entity;
    }
}
