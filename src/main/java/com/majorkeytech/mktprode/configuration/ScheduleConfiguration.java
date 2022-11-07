package com.majorkeytech.mktprode.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.majorkeytech.mktprode.service.MatchService;
import com.majorkeytech.mktprode.service.helper.PointsCalculator;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@AllArgsConstructor
public class ScheduleConfiguration {
    public static final int TWO_HOURS_DELAY = 7200000;

    private final MatchService matchService;
    private final PointsCalculator pointsCalculator;

    @Scheduled(fixedDelay = TWO_HOURS_DELAY, initialDelay = TWO_HOURS_DELAY)
    public void updateData() throws JsonProcessingException {
        matchService.updateDBMatches();
        pointsCalculator.updatePointsPerPrediction();
        pointsCalculator.updatePointsPerPlayer();
    }
}
