package com.corujito.champz.rest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.corujito.champz.rest.PhaseUtils;
import com.corujito.champz.rest.model.Phase;
import com.corujito.champz.rest.repository.IPhaseRepository;
import com.corujito.champz.rest.repository.entity.PhaseEntity;

@RunWith(MockitoJUnitRunner.class)
public class IPhaseServiceTest {

    @InjectMocks
    @Autowired
    PhaseServiceImpl phaseService;

    @Mock
    IPhaseRepository repository;

    @Test
    public void testGetPhase() throws Exception {
        Optional<PhaseEntity> x = Optional.of(PhaseUtils.createPhaseEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        Phase phase = phaseService.getPhase("1");
        PhaseUtils.assertObjects(x.get(), phase);
    }

    @Test
    public void testAddPhase() {
        PhaseEntity c = PhaseUtils.createPhaseEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Phase phase = phaseService.addPhase(new Phase());
        PhaseUtils.assertObjects(c, phase);
    }

    @Test
    public void testUpdatePhase() {
        PhaseEntity c = PhaseUtils.createPhaseEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Phase phase = phaseService.updatePhase(new Phase());
        PhaseUtils.assertObjects(c, phase);
    }

    @Test
    public void testGetAllPhases() {
        List<PhaseEntity> entities = Arrays.asList(PhaseUtils.createPhaseEntity("1"),
                PhaseUtils.createPhaseEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<Phase> phases = phaseService.getAllPhases();
        assertEquals(phases.size(), entities.size());
    }

    @Test
    public void testDelete() {
        phaseService.deletePhase("1");
        verify(repository, times(1)).deleteById("1");
    }
}
