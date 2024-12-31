package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Team;

public class TeamDAOImpl implements TeamDAO {

    private Connection connection;

    private DatabaseConnectionManager dbManager;
    public TeamDAOImpl(DatabaseConnectionManager dbManager) {
        this.dbManager = dbManager;
    }

     @Override
    public int addTeam(Team team) {
        String query = "INSERT INTO team (team_name, location, owner_name, establishment_year) VALUES (?, ?, ?, ?)";
        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, team.getTeamName());
            statement.setString(2, team.getLocation());
            statement.setString(3, team.getOwnerName());
            statement.setInt(4, team.getEstablishmentYear());
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Team getTeamById(int teamId) {
        Team team = null;
        String query = "SELECT * FROM team WHERE team_id = ?";
        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teamId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    team = new Team();
                    team.setTeamId(resultSet.getInt("team_id"));
                    team.setTeamName(resultSet.getString("team_name"));
                    team.setLocation(resultSet.getString("location"));
                    team.setOwnerName(resultSet.getString("owner_name"));
                    team.setEstablishmentYear(resultSet.getInt("establishment_year"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }

    @Override
    public void updateTeam(Team team) {
        String query = "UPDATE team SET team_name = ?, location = ?, owner_name = ?, establishment_year = ? WHERE team_id = ?";
        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, team.getTeamName());
            statement.setString(2, team.getLocation());
            statement.setString(3, team.getOwnerName());
            statement.setInt(4, team.getEstablishmentYear());
            statement.setInt(5, team.getTeamId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeam(int teamId) {
        String query = "DELETE FROM team WHERE team_id = ?";
        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teamId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        String query = "SELECT * FROM team";
        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Team team = new Team();
                team.setTeamId(resultSet.getInt("team_id"));
                team.setTeamName(resultSet.getString("team_name"));
                team.setLocation(resultSet.getString("location"));
                team.setOwnerName(resultSet.getString("owner_name"));
                team.setEstablishmentYear(resultSet.getInt("establishment_year"));
                teams.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }


}
