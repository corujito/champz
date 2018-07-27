package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.Player;

public interface IPlayerService {

    Player getPlayer(String id);

    List<Player> getAllPlayers();

    Player addPlayer(Player player);

    Player updatePlayer(Player player);

    void deletePlayer(String id);
}
