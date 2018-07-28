package com.corujito.champz.rest.resource;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.corujito.champz.rest.model.PlayerInscription;
import com.corujito.champz.rest.service.IPlayerInscriptionService;

@RestController
@RequestMapping("/api/playerInscriptions")
public class PlayerInscriptionResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerInscriptionResource.class);

    @Autowired
    IPlayerInscriptionService playerInscriptionService;

    @GetMapping(path = "/{id}")
    public PlayerInscription getPlayerInscription(@PathVariable String id) {
        LOGGER.debug("PlayerInscription.getPlayerInscription {}", id);
        return playerInscriptionService.getPlayerInscription(id);
    }

    @GetMapping
    public List<PlayerInscription> getAllPlayerInscriptions() {
        LOGGER.debug("PlayerInscription.getAllPlayerInscriptions");
        return playerInscriptionService.getAllPlayerInscriptions();
    }

    @PostMapping
    public PlayerInscription addPlayerInscription(@RequestBody PlayerInscription playerInscription) {
        LOGGER.debug("PlayerInscription.addPlayerInscription");
        return playerInscriptionService.addPlayerInscription(playerInscription);
    }

    @PutMapping(path = "/{id}")
    public PlayerInscription updatePlayerInscription(@PathVariable String id,
            @RequestBody PlayerInscription playerInscription) {
        LOGGER.debug("PlayerInscription.updatePlayerInscription {}", id);
        return playerInscriptionService.updatePlayerInscription(playerInscription);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePlayerInscription(@PathVariable String id) {
        LOGGER.debug("PlayerInscription.deletePlayerInscription {}", id);
        playerInscriptionService.deletePlayerInscription(id);
    }

}
