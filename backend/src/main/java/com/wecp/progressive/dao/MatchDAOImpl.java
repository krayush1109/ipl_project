package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Match;

public class MatchDAOImpl implements MatchDAO {
  
     @Override
    public int addMatch(Match match)  {
        Connection connection = null;
        PreparedStatement statement = null;
        int generatedID = -1;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "INSERT INTO matches (first_team_id, second_team_id, match_date, venue, result, status, winner_team_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setInt(1, match.getFirstTeamId());
            statement.setInt(2, match.getSecondTeamId());
            statement.setDate(3, new java.sql.Date(match.getMatchDate().getTime()));
            statement.setString(4, match.getVenue());
            statement.setString(5, match.getResult());
            statement.setString(6, match.getStatus());
            statement.setInt(7, match.getWinnerTeamId());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                generatedID = resultSet.getInt(1);
                match.setMatchId(generatedID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // throw e;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return generatedID;
    }

    @Override
    public Match getMatchById(int matchId)  {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM matches WHERE match_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, matchId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int firstTeamId = resultSet.getInt("first_team_id");
                int secondTeamId = resultSet.getInt("second_team_id");
                Date matchDate = resultSet.getDate("match_date");
                String venue = resultSet.getString("venue");
                String result = resultSet.getString("result");
                String status = resultSet.getString("status");
                int winnerTeamId = resultSet.getInt("winner_team_id");

                return new Match(matchId, firstTeamId, secondTeamId, matchDate, venue, result, status, winnerTeamId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // throw e;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void updateMatch(Match match)  {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "UPDATE matches SET first_team_id = ?, second_team_id = ?, match_date = ?, venue = ?, result = ?, status = ?, winner_team_id = ? WHERE match_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, match.getFirstTeamId());
            statement.setInt(2, match.getSecondTeamId());
            statement.setDate(3, new java.sql.Date(match.getMatchDate().getTime()));
            statement.setString(4, match.getVenue());
            statement.setString(5, match.getResult());
            statement.setString(6, match.getStatus());
            statement.setInt(7, match.getWinnerTeamId());
            statement.setInt(8, match.getMatchId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteMatch(int matchId)  {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "DELETE FROM matches WHERE match_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, matchId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Match> getAllMatches()  {
        List<Match> matches = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM matches";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int matchId = resultSet.getInt("match_id");
                int firstTeamId = resultSet.getInt("first_team_id");
                int secondTeamId = resultSet.getInt("second_team_id");
                Date matchDate = resultSet.getDate("match_date");
                String venue = resultSet.getString("venue");
                String result = resultSet.getString("result");
                String status = resultSet.getString("status");
                int winnerTeamId = resultSet.getInt("winner_team_id");

                matches.add(new Match(matchId, firstTeamId, secondTeamId, matchDate, venue, result, status, winnerTeamId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return matches;
    }

}
