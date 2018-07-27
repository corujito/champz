package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Player;
import com.corujito.champz.rest.repository.IPlayerRepository;
import com.corujito.champz.rest.repository.entity.PlayerEntity;

@Service
public class PlayerServiceImpl implements IPlayerService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IPlayerRepository repository;

    @Override
    public Player getPlayer(String id) {
        Optional<PlayerEntity> opt = repository.findById(id);
        return opt.map(p -> modelMapper.map(p, Player.class)).orElse(null);
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        List<PlayerEntity> entities = repository.findAll();
        for (PlayerEntity entity : entities) {
            players.add(modelMapper.map(entity, Player.class));
        }
        return players;
    }

    @Override
    public Player addPlayer(Player player) {
        PlayerEntity entity = repository.save(modelMapper.map(player, PlayerEntity.class));
        return modelMapper.map(entity, Player.class);
    }

    @Override
    public Player updatePlayer(Player player) {
        return addPlayer(player);
    }

    @Override
    public void deletePlayer(String id) {
        repository.deleteById(id);
    }
}
