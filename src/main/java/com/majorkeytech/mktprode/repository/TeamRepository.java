package com.majorkeytech.mktprode.repository;

import com.majorkeytech.mktprode.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    Team getTeamById(Integer id);
    Team getTeamByName(String name);
    Team getTeamByFdId(Integer fdId);
}
