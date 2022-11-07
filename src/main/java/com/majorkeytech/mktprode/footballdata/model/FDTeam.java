package com.majorkeytech.mktprode.footballdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FDTeam {
    private Integer id;
    private String name;
    private String crest;
}
