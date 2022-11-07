package com.majorkeytech.mktprode.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.majorkeytech.mktprode.model.entity.Team;

import java.util.List;

public interface TeamService {
    Team getTeamById(Integer id);
    Team getTeamByName(String name);
    Team getTeamByFdId(Integer fdId);
    void populateDbTeams() throws JsonProcessingException;

    List<Team> getAllTeams();
}
