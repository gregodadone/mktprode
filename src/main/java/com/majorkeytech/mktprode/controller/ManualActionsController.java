package com.majorkeytech.mktprode.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.majorkeytech.mktprode.footballdata.FootballDataMapper;
import com.majorkeytech.mktprode.footballdata.model.FDMatch;
import com.majorkeytech.mktprode.footballdata.model.FDTeam;
import com.majorkeytech.mktprode.service.MatchService;
import com.majorkeytech.mktprode.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.majorkeytech.mktprode.model.constants.Path.*;

@RestController
@RequestMapping(MANUAL)
@AllArgsConstructor
public class ManualActionsController {
    private final MatchService matchService;
    private final TeamService teamService;
    private final FootballDataMapper footballDataMapper;

    @GetMapping(TEAMS_FROM_FOOTBALL_DATA)
    public List<FDTeam> getTeams() throws JsonProcessingException {
        return footballDataMapper.getTeams();
    }

    @GetMapping(MATCHES_FROM_FOOTBALL_DATA)
    public List<FDMatch> getMatches() throws JsonProcessingException {
        return footballDataMapper.getMatches();
    }

    @PostMapping(POPULATE_TEAMS)
    public void populateTeamsDb() throws JsonProcessingException {
        teamService.populateDbTeams();
    }

    @PostMapping(POPULATE_MATCHES)
    public void populateMatchesDb() throws JsonProcessingException {
        matchService.populateDBMatches();
    }

    @PostMapping(UPDATE_MATCHES)
    public void updateMatchesDb() throws JsonProcessingException {
        matchService.updateDBMatches();
    }
}
