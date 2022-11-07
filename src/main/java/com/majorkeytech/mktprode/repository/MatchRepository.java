package com.majorkeytech.mktprode.repository;

import com.majorkeytech.mktprode.model.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
    Match getMatchById(Integer id);
    Match getMatchByFdId(Integer fdId);
    List<Match> getAllByGroup(String group);
    List<Match> getAllByStage(String stage);
}
