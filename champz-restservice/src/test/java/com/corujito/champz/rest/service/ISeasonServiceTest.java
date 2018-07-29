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
import com.corujito.champz.rest.SeasonUtils;
import com.corujito.champz.rest.model.Season;
import com.corujito.champz.rest.repository.ISeasonRepository;
import com.corujito.champz.rest.repository.entity.SeasonEntity;

@RunWith(MockitoJUnitRunner.class)
public class ISeasonServiceTest {

    @InjectMocks
    @Autowired
    SeasonServiceImpl seasonService;

    @Mock
    ISeasonRepository repository;

    @Test
    public void testGetSeason() throws Exception {
        Optional<SeasonEntity> x = Optional.of(SeasonUtils.createSeasonEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        Season season = seasonService.getSeason("1");
        SeasonUtils.assertObjects(x.get(), season);
    }

    @Test
    public void testAddSeason() {
        SeasonEntity c = SeasonUtils.createSeasonEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Season season = seasonService.addSeason(new Season());
        SeasonUtils.assertObjects(c, season);
    }

    @Test
    public void testUpdateSeason() {
        SeasonEntity c = SeasonUtils.createSeasonEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Season season = seasonService.updateSeason(new Season());
        SeasonUtils.assertObjects(c, season);
    }

    @Test
    public void testGetAllSeasons() {
        List<SeasonEntity> entities =
                Arrays.asList(SeasonUtils.createSeasonEntity("1"), SeasonUtils.createSeasonEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<Season> seasons = seasonService.getAllSeasons();
        assertEquals(seasons.size(), entities.size());
    }

    @Test
    public void testDelete() {
        seasonService.deleteSeason("1");
        verify(repository, times(1)).deleteById("1");
    }
}
