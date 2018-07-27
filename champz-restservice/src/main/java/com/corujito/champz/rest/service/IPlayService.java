package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.Play;

public interface IPlayService {

    Play getPlay(String id);

    List<Play> getAllPlays();

    Play addPlay(Play play);

    Play updatePlay(Play play);

    void deletePlay(String id);
}
