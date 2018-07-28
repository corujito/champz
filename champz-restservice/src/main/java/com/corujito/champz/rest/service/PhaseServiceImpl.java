package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Phase;
import com.corujito.champz.rest.repository.IPhaseRepository;
import com.corujito.champz.rest.repository.entity.PhaseEntity;

@Service
public class PhaseServiceImpl implements IPhaseService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IPhaseRepository repository;

    @Override
    public Phase getPhase(String id) {
        Optional<PhaseEntity> opt = repository.findById(id);
        return opt.map(c -> modelMapper.map(c, Phase.class)).orElse(null);
    }

    @Override
    public List<Phase> getAllPhases() {
        List<Phase> phases = new ArrayList<>();
        List<PhaseEntity> entities = repository.findAll();
        for (PhaseEntity entity : entities) {
            phases.add(modelMapper.map(entity, Phase.class));
        }
        return phases;
    }

    @Override
    public Phase addPhase(Phase phase) {
        PhaseEntity entity = repository.save(modelMapper.map(phase, PhaseEntity.class));
        return modelMapper.map(entity, Phase.class);
    }

    @Override
    public Phase updatePhase(Phase phase) {
        return addPhase(phase);
    }

    @Override
    public void deletePhase(String id) {
        repository.deleteById(id);
    }
}
