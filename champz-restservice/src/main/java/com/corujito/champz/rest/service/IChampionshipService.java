package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.Championship;

public interface IChampionshipService {

    Championship getChampionship(String id);

    Championship getChampionshipByUserIdAndName(String userId, String name);

    List<Championship> getAllChampionships();

    Championship addChampionship(Championship championship);

    Championship updateChampionship(Championship championship);

    void deleteChampionship(String id);
}
