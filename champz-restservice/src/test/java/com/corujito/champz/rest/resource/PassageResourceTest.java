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
import com.corujito.champz.rest.PassageUtils;
import com.corujito.champz.rest.model.Passage;
import com.corujito.champz.rest.service.IPassageService;

@RunWith(MockitoJUnitRunner.class)
public class PassageResourceTest {

    @InjectMocks
    @Autowired
    PassageResource passageResource;

    @Mock
    IPassageService passageService;

    @Before
    public void before() {}

    @Test
    public void testGetPassage() throws Exception {
        when(passageService.getPassage("1")).thenReturn(PassageUtils.createPassage("1"));

        Passage passage = passageResource.getPassage("1");
        assertThat(passage, notNullValue());
    }

    @Test
    public void testAddPassage() {
        Passage c = PassageUtils.createPassage("1");
        when(passageService.addPassage(c)).thenReturn(c);

        Passage passage = passageResource.addPassage(c);
        assertThat(passage, notNullValue());
    }

    @Test
    public void testUpdatePassage() {
        Passage c = PassageUtils.createPassage("1");
        when(passageService.updatePassage(c)).thenReturn(c);

        Passage passage = passageResource.updatePassage(c.getId(), c);
        assertThat(passage, notNullValue());
    }

    @Test
    public void testGetAllPassages() {
        List<Passage> list =
                Arrays.asList(PassageUtils.createPassage("1"), PassageUtils.createPassage("2"));
        when(passageService.getAllPassages()).thenReturn(list);

        List<Passage> passages = passageResource.getAllPassages();
        assertEquals(passages.size(), list.size());
    }

    @Test
    public void testDelete() {
        passageResource.deletePassage("1");
        verify(passageService, times(1)).deletePassage("1");
    }
}
