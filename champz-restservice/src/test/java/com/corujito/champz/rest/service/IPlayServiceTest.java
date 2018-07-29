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
import com.corujito.champz.rest.PlayUtils;
import com.corujito.champz.rest.model.Play;
import com.corujito.champz.rest.repository.IPlayRepository;
import com.corujito.champz.rest.repository.entity.PlayEntity;

@RunWith(MockitoJUnitRunner.class)
public class IPlayServiceTest {

    @InjectMocks
    @Autowired
    PlayServiceImpl playService;

    @Mock
    IPlayRepository repository;

    @Test
    public void testGetPlay() throws Exception {
        Optional<PlayEntity> x = Optional.of(PlayUtils.createPlayEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        Play play = playService.getPlay("1");
        PlayUtils.assertObjects(x.get(), play);
    }

    @Test
    public void testAddPlay() {
        PlayEntity c = PlayUtils.createPlayEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Play play = playService.addPlay(new Play());
        PlayUtils.assertObjects(c, play);
    }

    @Test
    public void testUpdatePlay() {
        PlayEntity c = PlayUtils.createPlayEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Play play = playService.updatePlay(new Play());
        PlayUtils.assertObjects(c, play);
    }

    @Test
    public void testGetAllPlays() {
        List<PlayEntity> entities =
                Arrays.asList(PlayUtils.createPlayEntity("1"), PlayUtils.createPlayEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<Play> plays = playService.getAllPlays();
        assertEquals(plays.size(), entities.size());
    }

    @Test
    public void testDelete() {
        playService.deletePlay("1");
        verify(repository, times(1)).deleteById("1");
    }
}
