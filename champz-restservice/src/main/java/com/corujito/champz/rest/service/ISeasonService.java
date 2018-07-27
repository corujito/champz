package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.Season;

public interface ISeasonService {

    Season getSeason(String id);

    List<Season> getAllSeasons();

    Season addSeason(Season season);

    Season updateSeason(Season season);

    void deleteSeason(String id);
}
