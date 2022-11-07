package com.majorkeytech.mktprode.service.impl;

import com.majorkeytech.mktprode.model.entity.Player;
import com.majorkeytech.mktprode.repository.PlayerRepository;
import com.majorkeytech.mktprode.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Override
    public Player getPlayerById(Integer id) {
        return playerRepository.getPlayerById(id);
    }

    @Override
    public List<Player> getAllPlayersOrderedByPoints() {
        return playerRepository.findAllByOrderByPointsDesc();
    }
}
