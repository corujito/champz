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
import com.corujito.champz.rest.model.Participant;
import com.corujito.champz.rest.service.IParticipantService;

@RestController
@RequestMapping("/api/participants")
public class ParticipantResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantResource.class);

    @Autowired
    IParticipantService participantService;

    @GetMapping(path = "/{id}")
    public Participant getParticipant(@PathVariable String id) {
        LOGGER.debug("Participant.getParticipant {}", id);
        return participantService.getParticipant(id);
    }

    @GetMapping
    public List<Participant> getAllParticipants() {
        LOGGER.debug("Participant.getAllParticipants");
        return participantService.getAllParticipants();
    }

    @PostMapping
    public Participant addParticipant(@RequestBody Participant participant) {
        LOGGER.debug("Participant.addParticipant");
        return participantService.addParticipant(participant);
    }

    @PutMapping(path = "/{id}")
    public Participant updateParticipant(@PathVariable String id, @RequestBody Participant participant) {
        LOGGER.debug("Participant.updateParticipant {}", id);
        return participantService.updateParticipant(participant);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteParticipant(@PathVariable String id) {
        LOGGER.debug("Participant.deleteParticipant {}", id);
        participantService.deleteParticipant(id);
    }

}
