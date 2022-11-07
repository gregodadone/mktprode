package com.majorkeytech.mktprode.controller;

import com.majorkeytech.mktprode.model.entity.Prediction;
import com.majorkeytech.mktprode.model.request.PostPredictionRequest;
import com.majorkeytech.mktprode.model.request.PutPredictionRequest;
import com.majorkeytech.mktprode.service.PredictionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.majorkeytech.mktprode.model.constants.Path.PREDICTIONS;
import static com.majorkeytech.mktprode.model.constants.Path.PREDICTIONS_BY_PLAYER;

@RestController
@RequestMapping(PREDICTIONS)
@AllArgsConstructor
public class PredictionController {
    private final PredictionService predictionService;

    @PostMapping
    public void postPrediction(@RequestBody PostPredictionRequest postPredictionRequest) {
        predictionService.postPrediction(postPredictionRequest);
    }

    @PutMapping
    public void putPrediction(@RequestBody PutPredictionRequest putPredictionRequest) {
        predictionService.putPrediction(putPredictionRequest);
    }

    @GetMapping(PREDICTIONS_BY_PLAYER)
    public List<Prediction> getPredictionsByPlayer(@PathVariable Integer playerId) {
        return predictionService.getPredictionsByPlayer(playerId);
    }
}
