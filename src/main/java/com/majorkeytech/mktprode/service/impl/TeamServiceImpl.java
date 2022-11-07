package com.majorkeytech.mktprode.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.majorkeytech.mktprode.footballdata.FootballDataMapper;
import com.majorkeytech.mktprode.footballdata.model.FDTeam;
import com.majorkeytech.mktprode.model.entity.Team;
import com.majorkeytech.mktprode.repository.TeamRepository;
import com.majorkeytech.mktprode.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final FootballDataMapper footballDataMapper;

    @Override
    public Team getTeamById(Integer id) {
        return teamRepository.getTeamById(id);
    }

    @Override
    public Team getTeamByName(String name) {
        return teamRepository.getTeamByName(name);
    }

    @Override
    public Team getTeamByFdId(Integer fdId) {
        return teamRepository.getTeamByFdId(fdId);
    }

    @Override
    public void populateDbTeams() throws JsonProcessingException {
        for (FDTeam fdTeam : footballDataMapper.getTeams()) {
            Team team = Team.builder()
                    .name(fdTeam.getName())
                    .crest(fdTeam.getCrest())
                    .fdId(fdTeam.getId())
                    .build();
            teamRepository.save(team);
        }
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
