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
import com.corujito.champz.rest.SeasonUtils;
import com.corujito.champz.rest.model.Season;
import com.corujito.champz.rest.service.ISeasonService;

@RunWith(MockitoJUnitRunner.class)
public class SeasonResourceTest {

    @InjectMocks
    @Autowired
    SeasonResource seasonResource;

    @Mock
    ISeasonService seasonService;

    @Before
    public void before() {}

    @Test
    public void testGetSeason() throws Exception {
        Season c = SeasonUtils.createSeason("1");
        when(seasonService.getSeason("1")).thenReturn(c);

        Season season = seasonResource.getSeason("1");
        SeasonUtils.assertObjects(season, c);
    }

    @Test
    public void testAddSeason() {
        Season c = SeasonUtils.createSeason("1");
        when(seasonService.addSeason(c)).thenReturn(c);

        Season season = seasonResource.addSeason(c);
        SeasonUtils.assertObjects(season, c);
    }

    @Test
    public void testUpdateSeason() {
        Season c = SeasonUtils.createSeason("1");
        when(seasonService.updateSeason(c)).thenReturn(c);

        Season season = seasonResource.updateSeason(c.getId(), c);
        SeasonUtils.assertObjects(season, c);
    }

    @Test
    public void testGetAllSeasons() {
        List<Season> list =
                Arrays.asList(SeasonUtils.createSeason("1"), SeasonUtils.createSeason("2"));
        when(seasonService.getAllSeasons()).thenReturn(list);

        List<Season> seasons = seasonResource.getAllSeasons();
        assertEquals(seasons.size(), list.size());
    }

    @Test
    public void testDelete() {
        seasonResource.deleteSeason("1");
        verify(seasonService, times(1)).deleteSeason("1");
    }
}
