package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wecp.progressive.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Long countByCategory(String category); 
    
    @Modifying 
    @Query("DELETE FROM Vote v WHERE v.team.id = ?1") 
    void deleteByTeamId(int teamId); 
    
    @Modifying 
    @Query("DELETE FROM Vote v WHERE v.cricketer.id = ?1") 
    void deleteByCricketerId(int cricketerId);

}
