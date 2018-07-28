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
import com.corujito.champz.rest.model.Phase;
import com.corujito.champz.rest.service.IPhaseService;

@RestController
@RequestMapping("/api/phases")
public class PhaseResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhaseResource.class);

    @Autowired
    IPhaseService phaseService;

    @GetMapping(path = "/{id}")
    public Phase getPhase(@PathVariable String id) {
        LOGGER.debug("Phase.getPhase {}", id);
        return phaseService.getPhase(id);
    }

    @GetMapping
    public List<Phase> getAllPhases() {
        LOGGER.debug("Phase.getAllPhases");
        return phaseService.getAllPhases();
    }

    @PostMapping
    public Phase addPhase(@RequestBody Phase phase) {
        LOGGER.debug("Phase.addPhase");
        return phaseService.addPhase(phase);
    }

    @PutMapping(path = "/{id}")
    public Phase updatePhase(@PathVariable String id, @RequestBody Phase phase) {
        LOGGER.debug("Phase.updatePhase {}", id);
        return phaseService.updatePhase(phase);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePhase(@PathVariable String id) {
        LOGGER.debug("Phase.deletePhase {}", id);
        phaseService.deletePhase(id);
    }

}
