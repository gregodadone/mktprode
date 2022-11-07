package com.majorkeytech.mktprode.service.impl;

import com.majorkeytech.mktprode.model.entity.Match;
import com.majorkeytech.mktprode.model.entity.Player;
import com.majorkeytech.mktprode.model.entity.Prediction;
import com.majorkeytech.mktprode.model.request.PostPredictionRequest;
import com.majorkeytech.mktprode.model.request.PutPredictionRequest;
import com.majorkeytech.mktprode.repository.PredictionRepository;
import com.majorkeytech.mktprode.service.MatchService;
import com.majorkeytech.mktprode.service.PlayerService;
import com.majorkeytech.mktprode.service.PredictionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
@AllArgsConstructor
@Transactional
public class PredictionServiceImpl implements PredictionService {
    private final PredictionRepository predictionRepository;
    private final PlayerService playerService;
    private final MatchService matchService;

    @Override
    public Prediction getPredictionById(Integer id) {
        return predictionRepository.getPredictionById(id);
    }

    @Override
    public List<Prediction> getPredictionsByPlayer(Integer playerId) {
        Player player = playerService.getPlayerById(playerId);
        return predictionRepository.getPredictionsByPlayer(player);
    }

    //obtener las predicciones que aun se pueden modificar
    //solo las que estan cruces definidos y son en mas de 24 hs

    @Override
    public List<Prediction> getPredictionsByMatch(Integer matchId) {
        Match match = matchService.getMatchById(matchId);
        return predictionRepository.getPredictionsByMatch(match);
    }

    @Override
    public List<Prediction> getPredictionsByFinished() {
        return predictionRepository.getPredictionsByFinished(TRUE);
    }

    @Override
    public List<Prediction> getPredictionsByPlayerAndFinished(Player player) {
        return predictionRepository.getPredictionsByPlayerAndFinished(player, TRUE);
    }

    @Override
    public void postPrediction(PostPredictionRequest postPredictionRequest) {
        Match match = matchService.getMatchById(postPredictionRequest.getMatchId());
        validateMatchTime(match.getDate());

        Player player = playerService.getPlayerById(postPredictionRequest.getPlayerId());

        Prediction prediction = Prediction.builder()
                .dateTime(LocalDateTime.now())
                .finished(FALSE)
                .points(0)
                .match(match)
                .player(player)
                .result(postPredictionRequest.getResult().toString())
                .build();
        predictionRepository.save(prediction);
    }

    @Override
    public void putPrediction(PutPredictionRequest putPredictionRequest) {
        Prediction prediction = predictionRepository.getPredictionById(putPredictionRequest.getPredictionId());
        validatePredictionAvailability(prediction.getFinished());

        Match match = prediction.getMatch();
        validateMatchTime(match.getDate());

        prediction.setResult(putPredictionRequest.getResult().toString());
        prediction.setDateTime(LocalDateTime.now());
        predictionRepository.save(prediction);
    }

    private void validateMatchTime(LocalDateTime dateTime) {
        if (dateTime.minusDays(1).isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "This match is in less than 24 hours"
            );
        }
    }

    private void validatePredictionAvailability(Boolean finished) {
        if (TRUE.equals(finished)) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "This match is finished"
            );
        }
    }
}
