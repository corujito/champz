package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.Phase;

public interface IPhaseService {

    Phase getPhase(String id);

    Phase getPhaseBySeasonIdAndName(String seasonId, String phaseName);

    List<Phase> getAllPhases();

    List<Phase> getPhasesBySeasonId(String seasonId);

    Phase addPhase(Phase phase);

    Phase updatePhase(Phase phase);

    void deletePhase(String id);
}
