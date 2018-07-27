package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Passage;
import com.corujito.champz.rest.repository.IPassageRepository;
import com.corujito.champz.rest.repository.entity.PassageEntity;

@Service
public class PassageServiceImpl implements IPassageService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IPassageRepository repository;

    @Override
    public Passage getPassage(String id) {
        Optional<PassageEntity> opt = repository.findById(id);
        return opt.map(c -> modelMapper.map(c, Passage.class)).orElse(null);
    }

    @Override
    public List<Passage> getAllPassages() {
        List<Passage> passages = new ArrayList<>();
        List<PassageEntity> entities = repository.findAll();
        for (PassageEntity entity : entities) {
            passages.add(modelMapper.map(entity, Passage.class));
        }
        return passages;
    }

    @Override
    public Passage addPassage(Passage passage) {
        PassageEntity entity = repository.save(modelMapper.map(passage, PassageEntity.class));
        return modelMapper.map(entity, Passage.class);
    }

    @Override
    public Passage updatePassage(Passage passage) {
        return addPassage(passage);
    }

    @Override
    public void deletePassage(String id) {
        repository.deleteById(id);
    }
}
