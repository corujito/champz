package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.Phase;

public interface IPhaseService {

    Phase getPhase(String id);

    List<Phase> getAllPhases();

    Phase addPhase(Phase phase);

    Phase updatePhase(Phase phase);

    void deletePhase(String id);
}
