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
import com.corujito.champz.rest.model.Play;
import com.corujito.champz.rest.service.IPlayService;

@RestController
@RequestMapping("/api/plays")
public class PlayResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayResource.class);

    @Autowired
    IPlayService playService;

    @GetMapping(path = "/{id}")
    public Play getPlay(@PathVariable String id) {
        LOGGER.debug("Play.getPlay {}", id);
        return playService.getPlay(id);
    }

    @GetMapping
    public List<Play> getAllPlays() {
        LOGGER.debug("Play.getAllPlays");
        return playService.getAllPlays();
    }

    @PostMapping
    public Play addPlay(@RequestBody Play play) {
        LOGGER.debug("Play.addPlay");
        return playService.addPlay(play);
    }

    @PutMapping(path = "/{id}")
    public Play updatePlay(@PathVariable String id, @RequestBody Play play) {
        LOGGER.debug("Play.updatePlay {}", id);
        return playService.updatePlay(play);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePlay(@PathVariable String id) {
        LOGGER.debug("Play.deletePlay {}", id);
        playService.deletePlay(id);
    }
}
