package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.PlayerTeamPassage;
import com.corujito.champz.rest.repository.IPlayerTeamPassageRepository;
import com.corujito.champz.rest.repository.entity.PlayerTeamPassageEntity;

@Service
public class PlayerTeamPassageServiceImpl implements IPlayerTeamPassageService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IPlayerTeamPassageRepository repository;

    @Override
    public PlayerTeamPassage getPlayerTeamPassage(String id) {
        Optional<PlayerTeamPassageEntity> opt = repository.findById(id);
        return opt.map(c -> modelMapper.map(c, PlayerTeamPassage.class)).orElse(null);
    }

    @Override
    public List<PlayerTeamPassage> getAllPlayerTeamPassages() {
        List<PlayerTeamPassage> playerTeamPassages = new ArrayList<>();
        List<PlayerTeamPassageEntity> entities = repository.findAll();
        for (PlayerTeamPassageEntity entity : entities) {
            playerTeamPassages.add(modelMapper.map(entity, PlayerTeamPassage.class));
        }
        return playerTeamPassages;
    }

    @Override
    public PlayerTeamPassage addPlayerTeamPassage(PlayerTeamPassage playerTeamPassage) {
        PlayerTeamPassageEntity entity =
                repository.save(modelMapper.map(playerTeamPassage, PlayerTeamPassageEntity.class));
        return modelMapper.map(entity, PlayerTeamPassage.class);
    }

    @Override
    public PlayerTeamPassage updatePlayerTeamPassage(PlayerTeamPassage playerTeamPassage) {
        return addPlayerTeamPassage(playerTeamPassage);
    }

    @Override
    public void deletePlayerTeamPassage(String id) {
        repository.deleteById(id);
    }
}
