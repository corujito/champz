package com.corujito.champz.rest.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.service.IChampionshipService;

@RestController
@RequestMapping("/api/championships")
public class ChampionshipResource {

    @Autowired
    IChampionshipService championshipService;

    @GetMapping(path = "/{id}")
    public Championship getChampionship(@PathVariable String id) {
        return championshipService.getChampionship(id);
    }

    @GetMapping
    public List<Championship> getAllChampionships() {
        return championshipService.getAllChampionships();
    }

    @PostMapping
    public Championship addChampionship(Championship championship) {
        return championshipService.addChampionship(championship);
    }

    @PutMapping(path = "/{id}")
    public Championship updateChampionship(@PathVariable String id, Championship championship) {
        return championshipService.updateChampionship(championship);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteChampionship(@PathVariable String id) {
        championshipService.deleteChampionship(id);
    }

}
