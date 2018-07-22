package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.corujito.champz.rest.controller.ChampionshipController;
import com.corujito.champz.rest.model.Championship;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChampionshipTest {

    @Autowired
    ChampionshipController championshipController;

    @Test
    public void getChampionship() throws Exception {
        Championship championship = championshipController.getChampionship("1");
        assertThat(championship.getName(), equalTo("1"));
    }
}
