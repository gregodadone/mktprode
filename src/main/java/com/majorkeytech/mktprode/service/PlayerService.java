package com.majorkeytech.mktprode.service;

import com.majorkeytech.mktprode.model.entity.Player;

import java.util.List;

public interface PlayerService {
    Player getPlayerById(Integer id);
    List<Player> getAllPlayersOrderedByPoints();
}
