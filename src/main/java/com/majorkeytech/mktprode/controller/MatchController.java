package com.majorkeytech.mktprode.controller;

import com.majorkeytech.mktprode.model.constants.Group;
import com.majorkeytech.mktprode.model.constants.Stage;
import com.majorkeytech.mktprode.model.entity.Match;
import com.majorkeytech.mktprode.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.majorkeytech.mktprode.model.constants.Path.*;

@RestController
@AllArgsConstructor
@RequestMapping(MATCHES)
public class MatchController {
    private final MatchService matchService;

    @GetMapping(ALL_MATCHES)
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping(MATCH_BY_ID)
    public Match getMatchById(@PathVariable Integer id) {
        return matchService.getMatchById(id);
    }

    @GetMapping(MATCHES_BY_GROUP)
    public List<Match> getMatchesByGroup(@PathVariable Group group) {
        return matchService.getMatchesByGroup(group);
    }

    @GetMapping(MATCHES_BY_STAGE)
    public List<Match> getMatchesByStage(@PathVariable Stage stage) {
        return matchService.getMatchesByStage(stage);
    }

    //partidos disponibles para marcar para el usuario
}
