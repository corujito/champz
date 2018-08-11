package com.corujito.champz.rest.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.corujito.champz.rest.model.SeasonSummary;
import com.corujito.champz.rest.service.ISeasonSummaryService;

@RestController
@RequestMapping("/api/seasonsSummary")
public class SeasonSummaryResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeasonSummaryResource.class);

    @Autowired
    ISeasonSummaryService seasonSummaryService;

    @GetMapping(path = "/{id}")
    public SeasonSummary getSeasonSummary(@PathVariable String id) {
        LOGGER.debug("Season.getSeasonSummary {}", id);
        return seasonSummaryService.getSeasonSummary(id);
    }
}
