package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.wecp.progressive.dao.TeamDAO;
import com.wecp.progressive.entity.Team;
import com.wecp.progressive.service.TeamService;

public class TeamServiceImplJdbc implements TeamService {

    private TeamDAO teamDAO;

    public TeamServiceImplJdbc(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @Override
    public int addTeam(Team team) {
        return teamDAO.addTeam(team);
    }

    @Override
    public Team getTeamById(int teamId) {
        return teamDAO.getTeamById(teamId);
    }

    @Override
    public void updateTeam(Team team) {
        teamDAO.updateTeam(team);
    }

    @Override
    public void deleteTeam(int teamId) {
        teamDAO.deleteTeam(teamId);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamDAO.getAllTeams();
    }

@Override
public List<Team> getAllTeamsSortedByName() {
    List<Team> teams = teamDAO.getAllTeams();
    return teams.stream()
                .sorted(Comparator.comparing(Team::getTeamName))
                .collect(Collectors.toList());
}

}