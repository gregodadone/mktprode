package com.majorkeytech.mktprode.repository;

import com.majorkeytech.mktprode.model.entity.Match;
import com.majorkeytech.mktprode.model.entity.Player;
import com.majorkeytech.mktprode.model.entity.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Integer> {
    Prediction getPredictionById(Integer id);
    List<Prediction> getPredictionsByPlayer(Player player);
    List<Prediction> getPredictionsByFinished(Boolean finished);
    List<Prediction> getPredictionsByMatch(Match match);
    List<Prediction> getPredictionsByFinishedAndMatch_Status(Boolean finished, String status);
    List<Prediction> getPredictionsByPlayerAndFinished(Player player, Boolean finished);
}
