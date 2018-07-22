package com.corujito.champz.rest.resource;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.service.IChampionshipService;

@RunWith(MockitoJUnitRunner.class)
public class ChampionshipResourceTest {

    @InjectMocks
    @Autowired
    ChampionshipResource championshipResource;

    @Mock
    IChampionshipService championshipService;

    @Before
    public void before() {
        when(championshipService.getChampionship("1")).thenReturn(new Championship());
    }

    @Test
    public void getChampionship() throws Exception {
        Championship championship = championshipResource.getChampionship("1");
        assertThat(championship, notNullValue());
    }
}
