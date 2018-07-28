package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.PlayerTeamPassage;

public interface IPlayerTeamPassageService {

    PlayerTeamPassage getPlayerTeamPassage(String id);

    List<PlayerTeamPassage> getAllPlayerTeamPassages();

    PlayerTeamPassage addPlayerTeamPassage(PlayerTeamPassage playerTeamPassage);

    PlayerTeamPassage updatePlayerTeamPassage(PlayerTeamPassage playerTeamPassage);

    void deletePlayerTeamPassage(String id);
}
