package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.Season;

public interface ISeasonService {

    Season getSeason(String id);

    Season getSeasonByChampionshipIdAndTitle(String championshipId, String title);

    List<Season> getAllSeasons();

    Season addSeason(Season season);

    Season updateSeason(Season season);

    void deleteSeason(String id);
}
