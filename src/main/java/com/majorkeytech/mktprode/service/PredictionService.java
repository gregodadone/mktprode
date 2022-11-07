package com.majorkeytech.mktprode.service;

import com.majorkeytech.mktprode.model.entity.Player;
import com.majorkeytech.mktprode.model.entity.Prediction;
import com.majorkeytech.mktprode.model.request.PostPredictionRequest;
import com.majorkeytech.mktprode.model.request.PutPredictionRequest;

import java.util.List;

public interface PredictionService {
    Prediction getPredictionById(Integer id);
    List<Prediction> getPredictionsByPlayer(Integer playerId);
    List<Prediction> getPredictionsByMatch(Integer matchId);

    List<Prediction> getPredictionsByFinished();

    List<Prediction> getPredictionsByPlayerAndFinished(Player player);

    void postPrediction(PostPredictionRequest postPredictionRequest);

    void putPrediction(PutPredictionRequest putPredictionRequest);
}
