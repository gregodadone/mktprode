package com.majorkeytech.mktprode.controller;

import com.majorkeytech.mktprode.model.entity.Team;
import com.majorkeytech.mktprode.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.majorkeytech.mktprode.model.constants.Path.*;

@RestController
@AllArgsConstructor
@RequestMapping(TEAMS)
public class TeamController {
    private final TeamService teamService;

    @GetMapping(ALL_TEAMS)
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping(TEAM_BY_ID)
    public Team getTeamById(@PathVariable Integer id) {
        return teamService.getTeamById(id);
    }

    @GetMapping(TEAM_BY_NAME)
    public Team getTeamByName(@PathVariable String name) {
        return teamService.getTeamByName(name);
    }
}
