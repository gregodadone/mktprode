package com.majorkeytech.mktprode.footballdata;

import com.majorkeytech.mktprode.model.constants.Competition;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class FootballDataClient {
    private final WebClient webClient;

    public FootballDataClient(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://api.football-data.org/v4/competitions/")
                .defaultHeader("X-Auth-Token", "37635ee384ef45139b60ae8832dd052f")
                .build();
    }

    public String getCompetitionMatchesData(Competition competition, int season) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("{competition}/matches")
                        .queryParam("season", season)
                        .build(competition.getShortName()))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getCompetitionTeamsData(Competition competition, int season) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("{competition}/teams")
                        .queryParam("season", season)
                        .build(competition.getShortName()))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
