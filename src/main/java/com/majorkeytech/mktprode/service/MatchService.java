package com.majorkeytech.mktprode.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.majorkeytech.mktprode.model.constants.Group;
import com.majorkeytech.mktprode.model.constants.Stage;
import com.majorkeytech.mktprode.model.entity.Match;

import java.util.List;

public interface MatchService {
    void populateDBMatches() throws JsonProcessingException;
    void updateDBMatches() throws JsonProcessingException;
    List<Match> getAllMatches();
    Match getMatchById(Integer id);
    List<Match> getMatchesByGroup(Group group);
    List<Match> getMatchesByStage(Stage stage);
}
