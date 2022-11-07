package com.majorkeytech.mktprode.model.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Path {

    // GENERAL
    public static final String API = "/api/v1";

    // Matches
    public static final String MATCHES = API + "/matches";
    public static final String ALL_MATCHES = "/all";
    public static final String MATCH_BY_ID = "/id/{id}";
    public static final String MATCHES_BY_GROUP = "/groups/{group}";
    public static final String MATCHES_BY_STAGE = "/stage/{stage}";

    // Teams
    public static final String TEAMS = API + "/teams";
    public static final String ALL_TEAMS = "/all";
    public static final String TEAM_BY_ID = "/id/{id}";
    public static final String TEAM_BY_NAME = "/name/{name}";

    // Prediction
    public static final String PREDICTIONS = API + "/predictions";
    public static final String PREDICTIONS_BY_PLAYER = "/player/{playerId}";

    // Manual actions
    public static final String MANUAL = API + "/manual";
    public static final String TEAMS_FROM_FOOTBALL_DATA = "/get-teams-from-football-data";
    public static final String MATCHES_FROM_FOOTBALL_DATA = "/get-matches-from-football-data";
    public static final String POPULATE = "/populate";
    public static final String POPULATE_TEAMS = POPULATE + "/teams";
    public static final String POPULATE_MATCHES = POPULATE + "/matches";
    public static final String UPDATE = "/update";
    public static final String UPDATE_MATCHES = UPDATE + "/matches";
    public static final String UPDATE_POINTS = UPDATE + "/points";
    public static final String UPDATE_POINTS_PER_PREDICTION = UPDATE_POINTS + "/predictions";
    public static final String UPDATE_POINTS_PER_PLAYER = UPDATE_POINTS + "/players";
}
