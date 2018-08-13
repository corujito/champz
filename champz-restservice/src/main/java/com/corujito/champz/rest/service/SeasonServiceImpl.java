package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Season;
import com.corujito.champz.rest.repository.ISeasonRepository;
import com.corujito.champz.rest.repository.entity.SeasonEntity;

@Service
public class SeasonServiceImpl implements ISeasonService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ISeasonRepository repository;

    @Override
    public Season getSeason(String id) {
        Optional<SeasonEntity> opt = repository.findById(id);
        return opt.map(s -> modelMapper.map(s, Season.class)).orElse(null);
    }

    @Override
    public Season getSeasonByChampionshipIdAndTitle(String championshipId, String title) {
        Optional<SeasonEntity> opt = repository.findByChampionshipIdAndTitle(championshipId, title);
        return opt.map(s -> modelMapper.map(s, Season.class)).orElse(null);
    }

    @Override
    public List<Season> getAllSeasons() {
        List<Season> seasons = new ArrayList<>();
        List<SeasonEntity> entities = repository.findAll();
        for (SeasonEntity entity : entities) {
            seasons.add(modelMapper.map(entity, Season.class));
        }
        return seasons;
    }

    @Override
    public Season addSeason(Season season) {
        SeasonEntity entity = repository.save(modelMapper.map(season, SeasonEntity.class));
        return modelMapper.map(entity, Season.class);
    }

    @Override
    public Season updateSeason(Season season) {
        return addSeason(season);
    }

    @Override
    public void deleteSeason(String id) {
        repository.deleteById(id);
    }
}
