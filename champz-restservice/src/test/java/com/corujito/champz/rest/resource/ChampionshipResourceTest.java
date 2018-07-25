package com.corujito.champz.rest.resource;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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
import com.corujito.champz.rest.ChampionshipUtils;
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.service.IChampionshipService;

@RunWith(MockitoJUnitRunner.class)
public class ChampionshipResourceTest {

    @InjectMocks
    @Autowired
    ChampionshipResource championshipResource;

    @Mock
    IChampionshipService championshipService;

    @Before
    public void before() {}

    @Test
    public void testGetChampionship() throws Exception {
        when(championshipService.getChampionship("1")).thenReturn(ChampionshipUtils.createChampionship("1"));

        Championship championship = championshipResource.getChampionship("1");
        assertThat(championship, notNullValue());
    }

    @Test
    public void testAddChampionship() {
        Championship c = ChampionshipUtils.createChampionship("1");
        when(championshipService.addChampionship(c)).thenReturn(c);

        Championship championship = championshipResource.addChampionship(c);
        assertThat(championship, notNullValue());
    }

    @Test
    public void testUpdateChampionship() {
        Championship c = ChampionshipUtils.createChampionship("1");
        when(championshipService.updateChampionship(c)).thenReturn(c);

        Championship championship = championshipResource.updateChampionship(c.getId(), c);
        assertThat(championship, notNullValue());
    }

    @Test
    public void testGetAllChampionships() {
        List<Championship> list =
                Arrays.asList(ChampionshipUtils.createChampionship("1"), ChampionshipUtils.createChampionship("2"));
        when(championshipService.getAllChampionships()).thenReturn(list);

        List<Championship> championships = championshipResource.getAllChampionships();
        assertEquals(championships.size(), list.size());
    }

    @Test
    public void testDelete() {
        championshipResource.deleteChampionship("1");
        verify(championshipService, times(1)).deleteChampionship("1");
    }
}
