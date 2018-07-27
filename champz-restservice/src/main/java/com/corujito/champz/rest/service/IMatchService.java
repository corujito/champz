package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.Match;

public interface IMatchService {

    Match getMatch(String id);

    List<Match> getAllMatchs();

    Match addMatch(Match match);

    Match updateMatch(Match match);

    void deleteMatch(String id);
}
