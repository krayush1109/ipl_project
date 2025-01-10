package com.wecp.progressive.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.TicketBooking;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer> {

    // List<TicketBooking> findByEmail(String email);

    // @Modifying 
    // @Query("DELETE FROM TicketBooking tb WHERE tb.match.id = :matchId") 
    // void deleteByMatchId(@Param("matchId") int matchId); 
    
    // @Modifying 
    // @Query("DELETE FROM TicketBooking tb WHERE tb.match.team1.id = :teamId OR tb.match.team2.id = :teamId") 
    // void deleteByTeamId(@Param("teamId") int teamId);

    List<TicketBooking> findByEmail(String email);

    @Modifying
    @Transactional
    @Query("DELETE FROM TicketBooking t WHERE t.match.matchId IN (SELECT m.matchId FROM matches m WHERE m.firstTeam.teamId = :teamId OR m.secondTeam.teamId = :teamId)")
    void deleteByTeamId(@Param("teamId") int teamId);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM TicketBooking t WHERE t.match.matchId IN :matchId")
    void deleteByMatchId(@Param("matchId") int matchId);

}
