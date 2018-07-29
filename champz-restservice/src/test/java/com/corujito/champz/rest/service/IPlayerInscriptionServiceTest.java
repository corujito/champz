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
import com.corujito.champz.rest.PlayerInscriptionUtils;
import com.corujito.champz.rest.model.PlayerInscription;
import com.corujito.champz.rest.repository.IPlayerInscriptionRepository;
import com.corujito.champz.rest.repository.entity.PlayerInscriptionEntity;

@RunWith(MockitoJUnitRunner.class)
public class IPlayerInscriptionServiceTest {

    @InjectMocks
    @Autowired
    PlayerInscriptionServiceImpl playerInscriptionService;

    @Mock
    IPlayerInscriptionRepository repository;

    @Test
    public void testGetPlayerInscription() throws Exception {
        Optional<PlayerInscriptionEntity> x = Optional.of(PlayerInscriptionUtils.createPlayerInscriptionEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        PlayerInscription playerInscription = playerInscriptionService.getPlayerInscription("1");
        PlayerInscriptionUtils.assertObjects(x.get(), playerInscription);
    }

    @Test
    public void testAddPlayerInscription() {
        PlayerInscriptionEntity c = PlayerInscriptionUtils.createPlayerInscriptionEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        PlayerInscription playerInscription = playerInscriptionService.addPlayerInscription(new PlayerInscription());
        PlayerInscriptionUtils.assertObjects(c, playerInscription);
    }

    @Test
    public void testUpdatePlayerInscription() {
        PlayerInscriptionEntity c = PlayerInscriptionUtils.createPlayerInscriptionEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        PlayerInscription playerInscription = playerInscriptionService.updatePlayerInscription(new PlayerInscription());
        PlayerInscriptionUtils.assertObjects(c, playerInscription);
    }

    @Test
    public void testGetAllPlayerInscriptions() {
        List<PlayerInscriptionEntity> entities =
                Arrays.asList(PlayerInscriptionUtils.createPlayerInscriptionEntity("1"),
                        PlayerInscriptionUtils.createPlayerInscriptionEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<PlayerInscription> playerInscriptions = playerInscriptionService.getAllPlayerInscriptions();
        assertEquals(playerInscriptions.size(), entities.size());
    }

    @Test
    public void testDelete() {
        playerInscriptionService.deletePlayerInscription("1");
        verify(repository, times(1)).deleteById("1");
    }
}
