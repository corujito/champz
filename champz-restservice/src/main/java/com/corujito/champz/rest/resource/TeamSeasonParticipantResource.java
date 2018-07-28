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
import com.corujito.champz.rest.model.TeamSeasonParticipant;
import com.corujito.champz.rest.service.ITeamSeasonParticipantService;

@RestController
@RequestMapping("/api/teamSeasonParticipants")
public class TeamSeasonParticipantResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamSeasonParticipantResource.class);

    @Autowired
    ITeamSeasonParticipantService teamSeasonParticipantService;

    @GetMapping(path = "/{id}")
    public TeamSeasonParticipant getTeamSeasonParticipant(@PathVariable String id) {
        LOGGER.debug("TeamSeasonParticipant.getTeamSeasonParticipant {}", id);
        return teamSeasonParticipantService.getTeamSeasonParticipant(id);
    }

    @GetMapping
    public List<TeamSeasonParticipant> getAllTeamSeasonParticipants() {
        LOGGER.debug("TeamSeasonParticipant.getAllTeamSeasonParticipants");
        return teamSeasonParticipantService.getAllTeamSeasonParticipant();
    }

    @PostMapping
    public TeamSeasonParticipant addTeamSeasonParticipant(@RequestBody TeamSeasonParticipant teamSeasonParticipant) {
        LOGGER.debug("TeamSeasonParticipant.addTeamSeasonParticipant");
        return teamSeasonParticipantService.addTeamSeasonParticipant(teamSeasonParticipant);
    }

    @PutMapping(path = "/{id}")
    public TeamSeasonParticipant updateTeamSeasonParticipant(@PathVariable String id,
            @RequestBody TeamSeasonParticipant teamSeasonParticipant) {
        LOGGER.debug("TeamSeasonParticipant.updateTeamSeasonParticipant {}", id);
        return teamSeasonParticipantService.updateTeamSeasonParticipant(teamSeasonParticipant);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTeamSeasonParticipant(@PathVariable String id) {
        LOGGER.debug("TeamSeasonParticipant.deleteTeamSeasonParticipant {}", id);
        teamSeasonParticipantService.deleteTeamSeasonParticipant(id);
    }

}
