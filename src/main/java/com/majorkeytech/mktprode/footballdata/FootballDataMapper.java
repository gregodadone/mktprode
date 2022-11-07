package com.majorkeytech.mktprode.footballdata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.majorkeytech.mktprode.footballdata.model.FDMatch;
import com.majorkeytech.mktprode.footballdata.model.FDTeam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static com.majorkeytech.mktprode.model.constants.Competition.WORLD_CUP;

@Component
@AllArgsConstructor
public class FootballDataMapper {
    private final FootballDataClient footballDataClient;
    private final ObjectMapper mapper;

    public List<FDMatch> getMatches() throws JsonProcessingException {
        String json = footballDataClient.getCompetitionMatchesData(WORLD_CUP, 2022);
        JsonNode rootNode = mapper.readTree(json);
        JsonNode rootData = rootNode.at("/matches");
        FDMatch[] fdMatches = mapper.treeToValue(rootData, FDMatch[].class);

        return Arrays.asList(fdMatches);
    }

    public List<FDTeam> getTeams() throws JsonProcessingException {
        String json = footballDataClient.getCompetitionTeamsData(WORLD_CUP, 2022);
        JsonNode rootNode = mapper.readTree(json);
        JsonNode rootData = rootNode.at("/teams");
        FDTeam[] fdTeams = mapper.treeToValue(rootData, FDTeam[].class);

        return Arrays.asList(fdTeams);
    }
}
