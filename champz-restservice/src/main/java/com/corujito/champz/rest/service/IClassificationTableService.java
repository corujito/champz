package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.ClassificationTable;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.model.Team;

public interface IClassificationTableService {

    ClassificationTable generateClassificationTable(List<Team> teams, List<Match> matches);

}
