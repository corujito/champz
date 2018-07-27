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
import com.corujito.champz.rest.PassageUtils;
import com.corujito.champz.rest.model.Passage;
import com.corujito.champz.rest.repository.IPassageRepository;
import com.corujito.champz.rest.repository.entity.PassageEntity;

@RunWith(MockitoJUnitRunner.class)
public class IPassageServiceTest {

    @InjectMocks
    @Autowired
    PassageServiceImpl passageService;

    @Mock
    IPassageRepository repository;

    @Test
    public void testGetPassage() throws Exception {
        Optional<PassageEntity> x = Optional.of(PassageUtils.createPassageEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        Passage passage = passageService.getPassage("1");
        assertThat(passage, notNullValue());
    }

    @Test
    public void testAddPassage() {
        PassageEntity c = PassageUtils.createPassageEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Passage passage = passageService.addPassage(new Passage());
        assertThat(passage, notNullValue());
    }

    @Test
    public void testUpdatePassage() {
        PassageEntity c = PassageUtils.createPassageEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Passage passage = passageService.updatePassage(new Passage());
        assertThat(passage, notNullValue());
    }

    @Test
    public void testGetAllPassages() {
        List<PassageEntity> entities = Arrays.asList(PassageUtils.createPassageEntity("1"),
                PassageUtils.createPassageEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<Passage> passages = passageService.getAllPassages();
        assertEquals(passages.size(), entities.size());
    }

    @Test
    public void testDelete() {
        passageService.deletePassage("1");
        verify(repository, times(1)).deleteById("1");
    }
}
