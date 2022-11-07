package com.majorkeytech.mktprode.model.request;

import com.majorkeytech.mktprode.model.constants.MatchResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPredictionRequest {
    private Integer playerId;
    private Integer matchId;
    private MatchResult result;
}
