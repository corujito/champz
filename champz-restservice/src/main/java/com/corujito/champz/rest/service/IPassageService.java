package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.Passage;

public interface IPassageService {

    Passage getPassage(String id);

    List<Passage> getAllPassages();

    Passage addPassage(Passage passage);

    Passage updatePassage(Passage passage);

    void deletePassage(String id);
}
