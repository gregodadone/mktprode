package com.majorkeytech.mktprode.footballdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FDMatch {
    private Integer id;
    private LocalDateTime utcDate;
    private String status;
    private String stage;
    private String group;
    private FDTeam homeTeam;
    private FDTeam awayTeam;
    private FDScore score;
}
