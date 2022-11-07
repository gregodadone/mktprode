package com.majorkeytech.mktprode.model.request;

import com.majorkeytech.mktprode.model.constants.MatchResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PutPredictionRequest {
    private Integer predictionId;
    private MatchResult result;
}
