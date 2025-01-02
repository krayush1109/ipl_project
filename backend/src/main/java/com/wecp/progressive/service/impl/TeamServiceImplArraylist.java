package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.wecp.progressive.entity.Team;
import com.wecp.progressive.service.TeamService;

public class TeamServiceImplArraylist implements TeamService {
    private List<Team> teams = new ArrayList<>();

    @Override
    public List<Team> getAllTeams() {        
        return teams;
    }

    @Override
    public int addTeam(Team team) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTeam'");
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllTeamsSortedByName'");
    }

}