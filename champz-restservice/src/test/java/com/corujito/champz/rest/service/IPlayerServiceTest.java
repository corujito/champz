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
import com.corujito.champz.rest.PlayerUtils;
import com.corujito.champz.rest.model.Player;
import com.corujito.champz.rest.repository.IPlayerRepository;
import com.corujito.champz.rest.repository.entity.PlayerEntity;

@RunWith(MockitoJUnitRunner.class)
public class IPlayerServiceTest {

    @InjectMocks
    @Autowired
    PlayerServiceImpl playerService;

    @Mock
    IPlayerRepository repository;

    @Test
    public void testGetPlayer() throws Exception {
        Optional<PlayerEntity> x = Optional.of(PlayerUtils.createPlayerEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        Player player = playerService.getPlayer("1");
        PlayerUtils.assertObjects(x.get(), player);
    }

    @Test
    public void testAddPlayer() {
        PlayerEntity c = PlayerUtils.createPlayerEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Player player = playerService.addPlayer(new Player());
        PlayerUtils.assertObjects(c, player);
    }

    @Test
    public void testUpdatePlayer() {
        PlayerEntity c = PlayerUtils.createPlayerEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Player player = playerService.updatePlayer(new Player());
        PlayerUtils.assertObjects(c, player);
    }

    @Test
    public void testGetAllPlayers() {
        List<PlayerEntity> entities =
                Arrays.asList(PlayerUtils.createPlayerEntity("1"), PlayerUtils.createPlayerEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<Player> players = playerService.getAllPlayers();
        assertEquals(players.size(), entities.size());
    }

    @Test
    public void testDelete() {
        playerService.deletePlayer("1");
        verify(repository, times(1)).deleteById("1");
    }
}
