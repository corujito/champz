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
import com.corujito.champz.rest.model.Passage;
import com.corujito.champz.rest.service.IPassageService;

@RestController
@RequestMapping("/api/passages")
public class PassageResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PassageResource.class);

    @Autowired
    IPassageService passageService;

    @GetMapping(path = "/{id}")
    public Passage getPassage(@PathVariable String id) {
        LOGGER.debug("Passage.getPassage {}", id);
        return passageService.getPassage(id);
    }

    @GetMapping
    public List<Passage> getAllPassages() {
        LOGGER.debug("Passage.getAllPassages");
        return passageService.getAllPassages();
    }

    @PostMapping
    public Passage addPassage(@RequestBody Passage passage) {
        LOGGER.debug("Passage.addPassage");
        return passageService.addPassage(passage);
    }

    @PutMapping(path = "/{id}")
    public Passage updatePassage(@PathVariable String id, @RequestBody Passage passage) {
        LOGGER.debug("Passage.updatePassage {}", id);
        return passageService.updatePassage(passage);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePassage(@PathVariable String id) {
        LOGGER.debug("Passage.deletePassage {}", id);
        passageService.deletePassage(id);
    }

}
