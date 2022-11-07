package com.majorkeytech.mktprode.repository;

import com.majorkeytech.mktprode.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player getPlayerById(Integer id);
    List<Player> findAllByOrderByPointsDesc();
}
