package com.majorkeytech.mktprode.service.helper;

import com.majorkeytech.mktprode.model.entity.Match;
import com.majorkeytech.mktprode.model.entity.Player;
import com.majorkeytech.mktprode.model.entity.Prediction;
import com.majorkeytech.mktprode.repository.PlayerRepository;
import com.majorkeytech.mktprode.repository.PredictionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.majorkeytech.mktprode.model.constants.MatchStatus.FINISHED;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Component
@AllArgsConstructor
public class PointsCalculator {
    private final PlayerRepository playerRepository;
    private final PredictionRepository predictionRepository;

    public List<Player> updatePointsPerPlayer() {
        List<Player> players = playerRepository.findAll();
        for (Player player : players) {
            List<Prediction> predictions = predictionRepository.getPredictionsByPlayerAndFinished(player, TRUE);
            player.setPoints(calculatePointsPerPlayer(predictions));
            playerRepository.save(player);
        }
        return players;
    }

    public List<Prediction> updatePointsPerPrediction() {
        List<Prediction> predictions = predictionRepository.getPredictionsByFinishedAndMatch_Status(FALSE, FINISHED);
        for (Prediction prediction : predictions) {
            prediction.setPoints(calculatePointsPerPrediction(prediction));
            prediction.setFinished(TRUE);
            predictionRepository.save(prediction);
        }

        return predictions;
    }

    private Integer calculatePointsPerPrediction(Prediction prediction) {
        Match match = prediction.getMatch();
        if (prediction.getResult().equals(match.getScore())) {
            return switch (match.getStage()) {
                case "GROUP_STAGE" -> 1;
                case "FINAL" -> 3;
                default -> 2;
            };
        }
        return 0;
    }

    private Integer calculatePointsPerPlayer(List<Prediction> predictions) {
        Integer points = 0;
        for (Prediction prediction : predictions) {
            points += prediction.getPoints();
        }
        return points;
    }
}
