package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.PlayerInscription;

public interface IPlayerInscriptionService {

    PlayerInscription getPlayerInscription(String id);

    List<PlayerInscription> getAllPlayerInscriptions();

    PlayerInscription addPlayerInscription(PlayerInscription playerInscription);

    PlayerInscription updatePlayerInscription(PlayerInscription playerInscription);

    void deletePlayerInscription(String id);
}
