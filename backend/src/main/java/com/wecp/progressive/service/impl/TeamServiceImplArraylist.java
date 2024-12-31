package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wecp.progressive.entity.Team;
import com.wecp.progressive.service.TeamService;

public class TeamServiceImplArraylist implements TeamService {
  
    private List<Team> teams = new ArrayList<>();

    @Override
    public int addTeam(Team team) {
        teams.add(team);
        return team.getTeamId();
    }

    @Override
    public Team getTeamById(int teamId) {
        return teams.stream()
                .filter(team -> team.getTeamId() == teamId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateTeam(Team team) {
        Team existingTeam = getTeamById(team.getTeamId());
        if (existingTeam != null) {
            existingTeam.setTeamName(team.getTeamName());
            existingTeam.setLocation(team.getLocation());
            existingTeam.setOwnerName(team.getOwnerName());
            existingTeam.setEstablishmentYear(team.getEstablishmentYear());
        }
    }

    @Override
    public void deleteTeam(int teamId) {
        teams.removeIf(team -> team.getTeamId() == teamId);
    }

    @Override
    public List<Team> getAllTeams() {
        return new ArrayList<>(teams);
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        List<Team> sortedTeams = new ArrayList<>(teams);
        Collections.sort(sortedTeams, Comparator.comparing(Team::getTeamName));
        return sortedTeams;
    }

}