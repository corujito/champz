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
import com.corujito.champz.rest.model.Player;
import com.corujito.champz.rest.service.IPlayerService;

@RestController
@RequestMapping("/api/players")
public class PlayerResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerResource.class);

    @Autowired
    IPlayerService playerService;

    @GetMapping(path = "/{id}")
    public Player getPlayer(@PathVariable String id) {
        LOGGER.debug("Player.getPlayer {}", id);
        return playerService.getPlayer(id);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        LOGGER.debug("Player.getAllPlayers");
        return playerService.getAllPlayers();
    }

    @PostMapping
    public Player addPlayer(@RequestBody @Validated({Player.New.class}) Player player) {
        LOGGER.debug("Player.addPlayer");
        return playerService.addPlayer(player);
    }

    @PutMapping(path = "/{id}")
    public Player updatePlayer(@PathVariable String id,
            @RequestBody @Validated({Player.Existing.class}) Player player) {
        LOGGER.debug("Player.updatePlayer {}", id);
        return playerService.updatePlayer(player);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePlayer(@PathVariable String id) {
        LOGGER.debug("Player.deletePlayer {}", id);
        playerService.deletePlayer(id);
    }

}
