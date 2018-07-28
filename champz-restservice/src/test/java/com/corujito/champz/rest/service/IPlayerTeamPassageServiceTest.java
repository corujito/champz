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
import com.corujito.champz.rest.PlayerTeamPassageUtils;
import com.corujito.champz.rest.model.PlayerTeamPassage;
import com.corujito.champz.rest.repository.IPlayerTeamPassageRepository;
import com.corujito.champz.rest.repository.entity.PlayerTeamPassageEntity;

@RunWith(MockitoJUnitRunner.class)
public class IPlayerTeamPassageServiceTest {

    @InjectMocks
    @Autowired
    PlayerTeamPassageServiceImpl playerTeamPassageService;

    @Mock
    IPlayerTeamPassageRepository repository;

    @Test
    public void testGetPlayerTeamPassage() throws Exception {
        Optional<PlayerTeamPassageEntity> x = Optional.of(PlayerTeamPassageUtils.createPlayerTeamPassageEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        PlayerTeamPassage playerTeamPassage = playerTeamPassageService.getPlayerTeamPassage("1");
        assertThat(playerTeamPassage, notNullValue());
    }

    @Test
    public void testAddPlayerTeamPassage() {
        PlayerTeamPassageEntity c = PlayerTeamPassageUtils.createPlayerTeamPassageEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        PlayerTeamPassage playerTeamPassage = playerTeamPassageService.addPlayerTeamPassage(new PlayerTeamPassage());
        assertThat(playerTeamPassage, notNullValue());
    }

    @Test
    public void testUpdatePlayerTeamPassage() {
        PlayerTeamPassageEntity c = PlayerTeamPassageUtils.createPlayerTeamPassageEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        PlayerTeamPassage playerTeamPassage = playerTeamPassageService.updatePlayerTeamPassage(new PlayerTeamPassage());
        assertThat(playerTeamPassage, notNullValue());
    }

    @Test
    public void testGetAllPlayerTeamPassages() {
        List<PlayerTeamPassageEntity> entities =
                Arrays.asList(PlayerTeamPassageUtils.createPlayerTeamPassageEntity("1"),
                        PlayerTeamPassageUtils.createPlayerTeamPassageEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<PlayerTeamPassage> playerTeamPassages = playerTeamPassageService.getAllPlayerTeamPassages();
        assertEquals(playerTeamPassages.size(), entities.size());
    }

    @Test
    public void testDelete() {
        playerTeamPassageService.deletePlayerTeamPassage("1");
        verify(repository, times(1)).deleteById("1");
    }
}
