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
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.service.IChampionshipService;

@RestController
@RequestMapping("/api/championships")
public class ChampionshipResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChampionshipResource.class);

    @Autowired
    IChampionshipService championshipService;

    @GetMapping(path = "/{id}")
    public Championship getChampionship(@PathVariable String id) {
        LOGGER.debug("Championship.getChampionship {}", id);
        return championshipService.getChampionship(id);
    }

    @GetMapping
    public List<Championship> getAllChampionships() {
        LOGGER.debug("Championship.getAllChampionships");
        return championshipService.getAllChampionships();
    }

    @PostMapping
    public Championship addChampionship(@RequestBody Championship championship) {
        LOGGER.debug("Championship.addChampionship");
        return championshipService.addChampionship(championship);
    }

    @PutMapping(path = "/{id}")
    public Championship updateChampionship(@PathVariable String id, @RequestBody Championship championship) {
        LOGGER.debug("Championship.updateChampionship {}", id);
        return championshipService.updateChampionship(championship);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteChampionship(@PathVariable String id) {
        LOGGER.debug("Championship.deleteChampionship {}", id);
        championshipService.deleteChampionship(id);
    }

}
