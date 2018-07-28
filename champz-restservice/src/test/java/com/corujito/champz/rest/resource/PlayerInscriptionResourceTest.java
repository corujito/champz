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
import com.corujito.champz.rest.PlayerInscriptionUtils;
import com.corujito.champz.rest.model.PlayerInscription;
import com.corujito.champz.rest.service.IPlayerInscriptionService;

@RunWith(MockitoJUnitRunner.class)
public class PlayerInscriptionResourceTest {

    @InjectMocks
    @Autowired
    PlayerInscriptionResource playerInscriptionResource;

    @Mock
    IPlayerInscriptionService playerInscriptionService;

    @Before
    public void before() {}

    @Test
    public void testGetPlayerInscription() throws Exception {
        when(playerInscriptionService.getPlayerInscription("1"))
                .thenReturn(PlayerInscriptionUtils.createPlayerInscription("1"));

        PlayerInscription playerInscription = playerInscriptionResource.getPlayerInscription("1");
        assertThat(playerInscription, notNullValue());
    }

    @Test
    public void testAddPlayerInscription() {
        PlayerInscription c = PlayerInscriptionUtils.createPlayerInscription("1");
        when(playerInscriptionService.addPlayerInscription(c)).thenReturn(c);

        PlayerInscription playerInscription = playerInscriptionResource.addPlayerInscription(c);
        assertThat(playerInscription, notNullValue());
    }

    @Test
    public void testUpdatePlayerInscription() {
        PlayerInscription c = PlayerInscriptionUtils.createPlayerInscription("1");
        when(playerInscriptionService.updatePlayerInscription(c)).thenReturn(c);

        PlayerInscription playerInscription = playerInscriptionResource.updatePlayerInscription(c.getId(), c);
        assertThat(playerInscription, notNullValue());
    }

    @Test
    public void testGetAllPlayerInscriptions() {
        List<PlayerInscription> list =
                Arrays.asList(PlayerInscriptionUtils.createPlayerInscription("1"),
                        PlayerInscriptionUtils.createPlayerInscription("2"));
        when(playerInscriptionService.getAllPlayerInscriptions()).thenReturn(list);

        List<PlayerInscription> playerInscriptions = playerInscriptionResource.getAllPlayerInscriptions();
        assertEquals(playerInscriptions.size(), list.size());
    }

    @Test
    public void testDelete() {
        playerInscriptionResource.deletePlayerInscription("1");
        verify(playerInscriptionService, times(1)).deletePlayerInscription("1");
    }
}
