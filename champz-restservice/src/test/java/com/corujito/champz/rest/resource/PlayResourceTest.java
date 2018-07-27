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
import com.corujito.champz.rest.PlayUtils;
import com.corujito.champz.rest.model.Play;
import com.corujito.champz.rest.service.IPlayService;

@RunWith(MockitoJUnitRunner.class)
public class PlayResourceTest {

    @InjectMocks
    @Autowired
    PlayResource playResource;

    @Mock
    IPlayService playService;

    @Before
    public void before() {}

    @Test
    public void testGetPlay() throws Exception {
        when(playService.getPlay("1")).thenReturn(PlayUtils.createPlay("1"));

        Play play = playResource.getPlay("1");
        assertThat(play, notNullValue());
    }

    @Test
    public void testAddPlay() {
        Play c = PlayUtils.createPlay("1");
        when(playService.addPlay(c)).thenReturn(c);

        Play play = playResource.addPlay(c);
        assertThat(play, notNullValue());
    }

    @Test
    public void testUpdatePlay() {
        Play c = PlayUtils.createPlay("1");
        when(playService.updatePlay(c)).thenReturn(c);

        Play play = playResource.updatePlay(c.getId(), c);
        assertThat(play, notNullValue());
    }

    @Test
    public void testGetAllPlays() {
        List<Play> list =
                Arrays.asList(PlayUtils.createPlay("1"), PlayUtils.createPlay("2"));
        when(playService.getAllPlays()).thenReturn(list);

        List<Play> plays = playResource.getAllPlays();
        assertEquals(plays.size(), list.size());
    }

    @Test
    public void testDelete() {
        playResource.deletePlay("1");
        verify(playService, times(1)).deletePlay("1");
    }
}
