package com.majorkeytech.mktprode.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.majorkeytech.mktprode.footballdata.FootballDataMapper;
import com.majorkeytech.mktprode.footballdata.model.FDMatch;
import com.majorkeytech.mktprode.model.constants.Group;
import com.majorkeytech.mktprode.model.constants.Stage;
import com.majorkeytech.mktprode.model.entity.Match;
import com.majorkeytech.mktprode.model.entity.Team;
import com.majorkeytech.mktprode.repository.MatchRepository;
import com.majorkeytech.mktprode.service.MatchService;
import com.majorkeytech.mktprode.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.majorkeytech.mktprode.model.constants.MatchStatus.FINISHED;

@Service
@AllArgsConstructor
@Transactional
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final TeamService teamService;
    private final FootballDataMapper footballDataMapper;

    @Override
    public void populateDBMatches() throws JsonProcessingException {
        for (FDMatch fdMatch : footballDataMapper.getMatches()) {
            Team homeTeam = teamService.getTeamByName(fdMatch.getHomeTeam().getName());
            Team awayTeam = teamService.getTeamByName(fdMatch.getAwayTeam().getName());
            Match match = Match.builder()
                    .date(fdMatch.getUtcDate())
                    .homeTeam(homeTeam)
                    .awayTeam(awayTeam)
                    .status(fdMatch.getStatus())
                    .stage(fdMatch.getStage())
                    .group(fdMatch.getGroup())
                    .score(fdMatch.getScore().getWinner())
                    .fdId(fdMatch.getId())
                    .build();
            matchRepository.save(match);
        }
    }

    @Override
    public void updateDBMatches() throws JsonProcessingException {
        List<FDMatch> fdMatches = footballDataMapper.getMatches();
        for (FDMatch fdMatch : fdMatches) {
            Match matchByFdId = matchRepository.getMatchByFdId(fdMatch.getId());
            if (
                    ((FINISHED.equals(fdMatch.getStatus()))
                            && !(fdMatch.getStatus().equals(matchByFdId.getStatus())))
                    || (((fdMatch.getHomeTeam().getName() != null) && (fdMatch.getAwayTeam().getName() != null))
                            && ((matchByFdId.getHomeTeam() == null) || (matchByFdId.getAwayTeam() == null)))
                    || ((fdMatch.getUtcDate() != null) && !(fdMatch.getUtcDate().equals(matchByFdId.getDate())))
            ) {
                updateMatch(matchByFdId, fdMatch);
            }
        }
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match getMatchById(Integer id) {
        return matchRepository.getMatchById(id);
    }

    @Override
    public List<Match> getMatchesByGroup(Group group) {
        return matchRepository.getAllByGroup(group.toString());
    }

    @Override
    public List<Match> getMatchesByStage(Stage stage) {
        return matchRepository.getAllByStage(stage.toString());
    }

    private void updateMatch(Match matchByFdId, FDMatch fdMatch) {
        Team homeTeam = teamService.getTeamByName(fdMatch.getHomeTeam().getName());
        Team awayTeam = teamService.getTeamByName(fdMatch.getAwayTeam().getName());
        matchByFdId.setHomeTeam(homeTeam);
        matchByFdId.setAwayTeam(awayTeam);
        matchByFdId.setStatus(fdMatch.getStatus());
        matchByFdId.setScore(fdMatch.getScore().getWinner());
        matchByFdId.setDate(fdMatch.getUtcDate());

        matchRepository.save(matchByFdId);
    }
}
