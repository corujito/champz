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
import com.corujito.champz.rest.PlayerUtils;
import com.corujito.champz.rest.model.Player;
import com.corujito.champz.rest.service.IPlayerService;

@RunWith(MockitoJUnitRunner.class)
public class PlayerResourceTest {

    @InjectMocks
    @Autowired
    PlayerResource playerResource;

    @Mock
    IPlayerService playerService;

    @Before
    public void before() {}

    @Test
    public void testGetPlayer() throws Exception {
        Player c = PlayerUtils.createPlayer("1");
        when(playerService.getPlayer("1")).thenReturn(c);

        Player player = playerResource.getPlayer("1");
        PlayerUtils.assertObjects(player, c);
    }

    @Test
    public void testAddPlayer() {
        Player c = PlayerUtils.createPlayer("1");
        when(playerService.addPlayer(c)).thenReturn(c);

        Player player = playerResource.addPlayer(c);
        PlayerUtils.assertObjects(player, c);
    }

    @Test
    public void testUpdatePlayer() {
        Player c = PlayerUtils.createPlayer("1");
        when(playerService.updatePlayer(c)).thenReturn(c);

        Player player = playerResource.updatePlayer(c.getId(), c);
        PlayerUtils.assertObjects(player, c);
    }

    @Test
    public void testGetAllPlayers() {
        List<Player> list =
                Arrays.asList(PlayerUtils.createPlayer("1"), PlayerUtils.createPlayer("2"));
        when(playerService.getAllPlayers()).thenReturn(list);

        List<Player> players = playerResource.getAllPlayers();
        assertEquals(players.size(), list.size());
    }

    @Test
    public void testDelete() {
        playerResource.deletePlayer("1");
        verify(playerService, times(1)).deletePlayer("1");
    }
}
