package com.corujito.champz.rest.resource;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.corujito.champz.rest.model.PlayerTeamPassage;
import com.corujito.champz.rest.service.IPlayerTeamPassageService;

@RestController
@RequestMapping("/api/playerTeamPassages")
public class PlayerTeamPassageResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerTeamPassageResource.class);

    @Autowired
    IPlayerTeamPassageService playerTeamPassageService;

    @GetMapping(path = "/{id}")
    public PlayerTeamPassage getPlayerTeamPassage(@PathVariable String id) {
        LOGGER.debug("PlayerTeamPassage.getPlayerTeamPassage {}", id);
        return playerTeamPassageService.getPlayerTeamPassage(id);
    }

    @GetMapping
    public List<PlayerTeamPassage> getAllPlayerTeamPassages() {
        LOGGER.debug("PlayerTeamPassage.getAllPlayerTeamPassages");
        return playerTeamPassageService.getAllPlayerTeamPassages();
    }

    @PostMapping
    public PlayerTeamPassage addPlayerTeamPassage(
            @RequestBody @Validated({PlayerTeamPassage.New.class}) PlayerTeamPassage playerTeamPassage) {
        LOGGER.debug("PlayerTeamPassage.addPlayerTeamPassage");
        return playerTeamPassageService.addPlayerTeamPassage(playerTeamPassage);
    }

    @PutMapping(path = "/{id}")
    public PlayerTeamPassage updatePlayerTeamPassage(@PathVariable String id,
            @RequestBody @Validated({PlayerTeamPassage.Existing.class}) PlayerTeamPassage playerTeamPassage) {
        LOGGER.debug("PlayerTeamPassage.updatePlayerTeamPassage {}", id);
        return playerTeamPassageService.updatePlayerTeamPassage(playerTeamPassage);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePlayerTeamPassage(@PathVariable String id) {
        LOGGER.debug("PlayerTeamPassage.deletePlayerTeamPassage {}", id);
        playerTeamPassageService.deletePlayerTeamPassage(id);
    }

}
