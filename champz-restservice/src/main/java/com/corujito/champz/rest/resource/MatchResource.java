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
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.service.IMatchService;

@RestController
@RequestMapping("/api/matchs")
public class MatchResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatchResource.class);

    @Autowired
    IMatchService matchService;

    @GetMapping(path = "/{id}")
    public Match getMatch(@PathVariable String id) {
        LOGGER.debug("Match.getMatch {}", id);
        return matchService.getMatch(id);
    }

    @GetMapping
    public List<Match> getAllMatchs() {
        LOGGER.debug("Match.getAllMatchs");
        return matchService.getAllMatches();
    }

    @PostMapping
    public Match addMatch(@RequestBody @Validated({Match.New.class}) Match match) {
        LOGGER.debug("Match.addMatch");
        return matchService.addMatch(match);
    }

    @PutMapping(path = "/{id}")
    public Match updateMatch(@PathVariable String id, @RequestBody @Validated({Match.Existing.class}) Match match) {
        LOGGER.debug("Match.updateMatch {}", id);
        return matchService.updateMatch(match);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteMatch(@PathVariable String id) {
        LOGGER.debug("Match.deleteMatch {}", id);
        matchService.deleteMatch(id);
    }

}
