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
import com.corujito.champz.rest.model.Team;
import com.corujito.champz.rest.service.ITeamService;

@RestController
@RequestMapping("/api/teams")
public class TeamResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamResource.class);

    @Autowired
    ITeamService teamService;

    @GetMapping(path = "/{id}")
    public Team getTeam(@PathVariable String id) {
        LOGGER.debug("Team.getTeam {}", id);
        return teamService.getTeam(id);
    }

    @GetMapping
    public List<Team> getAllTeams() {
        LOGGER.debug("Team.getAllTeams");
        return teamService.getAllTeams();
    }

    @PostMapping
    public Team addTeam(@RequestBody Team team) {
        LOGGER.debug("Team.addTeam");
        return teamService.addTeam(team);
    }

    @PutMapping(path = "/{id}")
    public Team updateTeam(@PathVariable String id, @RequestBody Team team) {
        LOGGER.debug("Team.updateTeam {}", id);
        return teamService.updateTeam(team);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTeam(@PathVariable String id) {
        LOGGER.debug("Team.deleteTeam {}", id);
        teamService.deleteTeam(id);
    }

}
