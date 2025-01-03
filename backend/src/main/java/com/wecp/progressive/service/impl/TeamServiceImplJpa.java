package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.dao.TeamDAO;
import com.wecp.progressive.entity.Team;
import com.wecp.progressive.repository.TeamRepository;
import com.wecp.progressive.service.TeamService;

@Service
public class TeamServiceImplJpa implements TeamService  {
   
    private TeamRepository teamRepository;
   
    @Autowired
    public TeamServiceImplJpa(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
 
    @Override
    public List<Team> getAllTeams() throws SQLException{
        return teamRepository.findAll();
       
    }
 
    @Override
    public int addTeam(Team team) throws SQLException{
        return teamRepository.save(team).getTeamId();
    }
 
    @Override
    public List<Team> getAllTeamsSortedByName() throws SQLException{
        List<Team> sortedTeam = teamRepository.findAll();
        sortedTeam.sort(Comparator.comparing(Team::getTeamName));
        return sortedTeam;
    }

    @Override
    public Team getTeamById(int teamId) throws SQLException{
        return teamRepository.findByTeamId(teamId);
    }

    public void updateTeam(Team team) throws SQLException{
        teamRepository.save(team);
    }

    public void deleteTeam(int teamId) throws SQLException{
        teamRepository.findByTeamId(teamId);
    }
}