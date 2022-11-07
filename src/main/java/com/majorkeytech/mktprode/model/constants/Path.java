package com.majorkeytech.mktprode.model.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Path {

    // GENERAL
    public static final String API = "/api/v1";

    // Matches
    public static final String MATCHES = API + "/matches";
    public static final String ALL_MATCHES = MATCHES + "/all";
    public static final String MATCH_BY_ID = MATCHES + "/id/{id}";
    public static final String MATCHES_BY_GROUP = MATCHES + "/groups/{group}";
    public static final String MATCHES_BY_STAGE = MATCHES + "/stage/{stage}";

    // Teams
    public static final String TEAMS = API + "/teams";
    public static final String ALL_TEAMS = TEAMS + "/all";
    public static final String TEAM_BY_ID = TEAMS + "/id/{id}";
    public static final String TEAM_BY_NAME = TEAMS + "/name/{name}";

    // Manual actions
    public static final String MANUAL = API + "/manual";
    public static final String TEAMS_FROM_FOOTBALL_DATA = MANUAL + "/get-teams-from-football-data";
    public static final String MATCHES_FROM_FOOTBALL_DATA = MANUAL + "/get-matches-from-football-data";
    public static final String POPULATE = MANUAL + "/populate";
    public static final String POPULATE_TEAMS = POPULATE + "/teams";
    public static final String POPULATE_MATCHES = POPULATE + "/matches";
    public static final String UPDATE = MANUAL + "/update";
    public static final String UPDATE_MATCHES = UPDATE + "/matches";
}
