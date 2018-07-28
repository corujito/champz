package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.PlayerInscription;
import com.corujito.champz.rest.repository.IPlayerInscriptionRepository;
import com.corujito.champz.rest.repository.entity.PlayerInscriptionEntity;

@Service
public class PlayerInscriptionServiceImpl implements IPlayerInscriptionService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IPlayerInscriptionRepository repository;

    @Override
    public PlayerInscription getPlayerInscription(String id) {
        Optional<PlayerInscriptionEntity> opt = repository.findById(id);
        return opt.map(c -> modelMapper.map(c, PlayerInscription.class)).orElse(null);
    }

    @Override
    public List<PlayerInscription> getAllPlayerInscriptions() {
        List<PlayerInscription> playerInscriptions = new ArrayList<>();
        List<PlayerInscriptionEntity> entities = repository.findAll();
        for (PlayerInscriptionEntity entity : entities) {
            playerInscriptions.add(modelMapper.map(entity, PlayerInscription.class));
        }
        return playerInscriptions;
    }

    @Override
    public PlayerInscription addPlayerInscription(PlayerInscription playerInscription) {
        PlayerInscriptionEntity entity = repository.save(modelMapper.map(playerInscription, PlayerInscriptionEntity.class));
        return modelMapper.map(entity, PlayerInscription.class);
    }

    @Override
    public PlayerInscription updatePlayerInscription(PlayerInscription playerInscription) {
        return addPlayerInscription(playerInscription);
    }

    @Override
    public void deletePlayerInscription(String id) {
        repository.deleteById(id);
    }
}
