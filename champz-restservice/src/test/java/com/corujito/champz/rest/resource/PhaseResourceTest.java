package com.corujito.champz.rest.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.corujito.champz.rest.PhaseUtils;
import com.corujito.champz.rest.model.Phase;
import com.corujito.champz.rest.service.IPhaseService;

@RunWith(MockitoJUnitRunner.class)
public class PhaseResourceTest {

    @InjectMocks
    @Autowired
    PhaseResource phaseResource;

    @Mock
    IPhaseService phaseService;

    @Before
    public void before() {}

    @Test
    public void testGetPhase() throws Exception {
        Phase c = PhaseUtils.createPhase("1");
        when(phaseService.getPhase("1")).thenReturn(c);

        Phase phase = phaseResource.getPhase("1");
        PhaseUtils.assertObjects(phase, c);
    }

    @Test
    public void testAddPhase() {
        Phase c = PhaseUtils.createPhase("1");
        when(phaseService.addPhase(c)).thenReturn(c);

        Phase phase = phaseResource.addPhase(c);
        PhaseUtils.assertObjects(phase, c);
    }

    @Test
    public void testUpdatePhase() {
        Phase c = PhaseUtils.createPhase("1");
        when(phaseService.updatePhase(c)).thenReturn(c);

        Phase phase = phaseResource.updatePhase(c.getId(), c);
        PhaseUtils.assertObjects(phase, c);
    }

    @Test
    public void testGetAllPhases() {
        List<Phase> list =
                Arrays.asList(PhaseUtils.createPhase("1"), PhaseUtils.createPhase("2"));
        when(phaseService.getAllPhases()).thenReturn(list);

        List<Phase> phases = phaseResource.getAllPhases();
        assertEquals(phases.size(), list.size());
    }

    @Test
    public void testDelete() {
        phaseResource.deletePhase("1");
        verify(phaseService, times(1)).deletePhase("1");
    }
}
