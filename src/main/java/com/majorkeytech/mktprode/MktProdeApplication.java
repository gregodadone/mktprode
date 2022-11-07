package com.majorkeytech.mktprode;

import com.majorkeytech.mktprode.repository.MatchRepository;
import com.majorkeytech.mktprode.repository.TeamRepository;
import com.majorkeytech.mktprode.service.MatchService;
import com.majorkeytech.mktprode.service.TeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MktProdeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MktProdeApplication.class, args);
    }

    @Bean
    CommandLineRunner run(MatchService matchService, MatchRepository matchRepository,
                          TeamService teamService, TeamRepository teamRepository) {
        return (args) -> {
            if (teamRepository.count() == 0L) {
                teamService.populateDbTeams();
            }
            if (matchRepository.count() == 0L) {
                matchService.populateDBMatches();
            } else {
                matchService.updateDBMatches();
            }
        };
    }
}
