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
import com.corujito.champz.rest.PlayerTeamPassageUtils;
import com.corujito.champz.rest.model.PlayerTeamPassage;
import com.corujito.champz.rest.service.IPlayerTeamPassageService;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTeamPassageResourceTest {

    @InjectMocks
    @Autowired
    PlayerTeamPassageResource passageResource;

    @Mock
    IPlayerTeamPassageService passageService;

    @Before
    public void before() {}

    @Test
    public void testGetPlayerTeamPassage() throws Exception {
        when(passageService.getPlayerTeamPassage("1")).thenReturn(PlayerTeamPassageUtils.createPlayerTeamPassage("1"));

        PlayerTeamPassage passage = passageResource.getPlayerTeamPassage("1");
        assertThat(passage, notNullValue());
    }

    @Test
    public void testAddPlayerTeamPassage() {
        PlayerTeamPassage c = PlayerTeamPassageUtils.createPlayerTeamPassage("1");
        when(passageService.addPlayerTeamPassage(c)).thenReturn(c);

        PlayerTeamPassage passage = passageResource.addPlayerTeamPassage(c);
        assertThat(passage, notNullValue());
    }

    @Test
    public void testUpdatePlayerTeamPassage() {
        PlayerTeamPassage c = PlayerTeamPassageUtils.createPlayerTeamPassage("1");
        when(passageService.updatePlayerTeamPassage(c)).thenReturn(c);

        PlayerTeamPassage passage = passageResource.updatePlayerTeamPassage(c.getId(), c);
        assertThat(passage, notNullValue());
    }

    @Test
    public void testGetAllPlayerTeamPassages() {
        List<PlayerTeamPassage> list =
                Arrays.asList(PlayerTeamPassageUtils.createPlayerTeamPassage("1"),
                        PlayerTeamPassageUtils.createPlayerTeamPassage("2"));
        when(passageService.getAllPlayerTeamPassages()).thenReturn(list);

        List<PlayerTeamPassage> passages = passageResource.getAllPlayerTeamPassages();
        assertEquals(passages.size(), list.size());
    }

    @Test
    public void testDelete() {
        passageResource.deletePlayerTeamPassage("1");
        verify(passageService, times(1)).deletePlayerTeamPassage("1");
    }
}
