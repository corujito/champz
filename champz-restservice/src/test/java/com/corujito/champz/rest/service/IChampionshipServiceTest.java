package com.corujito.champz.rest.service;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.repository.IChampionshipRepository;
import com.corujito.champz.rest.repository.entity.ChampionshipEntity;

@RunWith(MockitoJUnitRunner.class)
public class IChampionshipServiceTest {

    @InjectMocks
    @Autowired
    ChampionshipServiceImpl championshipService;

    @Mock
    IChampionshipRepository repository;

    @Test
    public void testGetChampionship() throws Exception {
        Optional<ChampionshipEntity> x = Optional.of(createChampionshipEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        Championship championship = championshipService.getChampionship("1");
        assertThat(championship, notNullValue());
    }

    @Test
    public void testAddChampionship() {
        ChampionshipEntity c = createChampionshipEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Championship championship = championshipService.addChampionship(new Championship());
        assertThat(championship, notNullValue());
    }

    @Test
    public void testUpdateChampionship() {
        ChampionshipEntity c = createChampionshipEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Championship championship = championshipService.updateChampionship(new Championship());
        assertThat(championship, notNullValue());
    }

    @Test
    public void testGetAllChampionships() {
        List<ChampionshipEntity> entities = Arrays.asList(createChampionshipEntity("1"), createChampionshipEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<Championship> championships = championshipService.getAllChampionships();
        assertEquals(championships.size(), entities.size());
    }

    @Test
    public void testDelete() {
        championshipService.deleteChampionship("1");
        verify(repository, times(1)).deleteById("1");
    }

    private ChampionshipEntity createChampionshipEntity(String id) {
        ChampionshipEntity championship = new ChampionshipEntity();
        championship.setId(id);
        championship.setDescription("description");
        championship.setName("name");
        return championship;
    }

}
