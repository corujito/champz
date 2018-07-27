package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Play;
import com.corujito.champz.rest.repository.IPlayRepository;
import com.corujito.champz.rest.repository.entity.PlayEntity;

@Service
public class PlayServiceImpl implements IPlayService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IPlayRepository repository;

    @Override
    public Play getPlay(String id) {
        Optional<PlayEntity> opt = repository.findById(id);
        return opt.map(p -> modelMapper.map(p, Play.class)).orElse(null);
    }

    @Override
    public List<Play> getAllPlays() {
        List<Play> plays = new ArrayList<>();
        List<PlayEntity> entities = repository.findAll();
        for (PlayEntity entity : entities) {
            plays.add(modelMapper.map(entity, Play.class));
        }
        return plays;
    }

    @Override
    public Play addPlay(Play play) {
        PlayEntity entity = repository.save(modelMapper.map(play, PlayEntity.class));
        return modelMapper.map(entity, Play.class);
    }

    @Override
    public Play updatePlay(Play play) {
        return addPlay(play);
    }

    @Override
    public void deletePlay(String id) {
        repository.deleteById(id);
    }
}
