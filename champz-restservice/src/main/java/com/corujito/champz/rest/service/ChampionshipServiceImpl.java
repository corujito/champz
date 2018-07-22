package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Championship;

@Service
public class ChampionshipServiceImpl implements IChampionshipService {

    @Override
    public Championship getChampionship(String id) {
        return new Championship();
    }

    @Override
    public List<Championship> getAllChampionships() {
        List<Championship> championships = new ArrayList<>();
        return championships;
    }

    @Override
    public Championship addChampionship(Championship championship) {
        return championship;
    }

    @Override
    public Championship updateChampionship(Championship championship) {
        return championship;
    }

    @Override
    public void deleteChampionship(String id) {}
}
