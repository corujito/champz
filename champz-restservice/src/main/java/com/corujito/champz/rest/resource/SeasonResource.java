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
import com.corujito.champz.rest.model.Season;
import com.corujito.champz.rest.service.ISeasonService;

@RestController
@RequestMapping("/api/seasons")
public class SeasonResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeasonResource.class);

    @Autowired
    ISeasonService seasonService;

    @GetMapping(path = "/{id}")
    public Season getSeason(@PathVariable String id) {
        LOGGER.debug("Season.getSeason {}", id);
        return seasonService.getSeason(id);
    }

    @GetMapping
    public List<Season> getAllSeasons() {
        LOGGER.debug("Season.getAllSeasons");
        return seasonService.getAllSeasons();
    }

    @PostMapping
    public Season addSeason(@RequestBody Season season) {
        LOGGER.debug("Season.addSeason");
        return seasonService.addSeason(season);
    }

    @PutMapping(path = "/{id}")
    public Season updateSeason(@PathVariable String id, @RequestBody Season season) {
        LOGGER.debug("Season.updateSeason {}", id);
        return seasonService.updateSeason(season);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSeason(@PathVariable String id) {
        LOGGER.debug("Season.deleteSeason {}", id);
        seasonService.deleteSeason(id);
    }
}
