package com.wecp.progressive.entity;

import javax.persistence.*;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int match_Id;
    int first_team_d;
    int second_team_Id;
    // Date matchDate;
    String venue;
    String result;
    String status;
    // "Pending" , "Scheduled", "Completed"

    int winner_team_id;

    public Match(int match_Id, int first_team_d, int second_team_Id, String venue, String result, String status,
            int winner_team_id) {
        this.match_Id = match_Id;
        this.first_team_d = first_team_d;
        this.second_team_Id = second_team_Id;
        this.venue = venue;
        this.result = result;
        this.status = status;
        this.winner_team_id = winner_team_id;
    }

    public int getMatch_Id() {
        return match_Id;
    }

    public void setMatch_Id(int match_Id) {
        this.match_Id = match_Id;
    }

    public int getFirst_team_d() {
        return first_team_d;
    }

    public void setFirst_team_d(int first_team_d) {
        this.first_team_d = first_team_d;
    }

    public int getSecond_team_Id() {
        return second_team_Id;
    }

    public void setSecond_team_Id(int second_team_Id) {
        this.second_team_Id = second_team_Id;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getWinner_team_id() {
        return winner_team_id;
    }

    public void setWinner_team_id(int winner_team_id) {
        this.winner_team_id = winner_team_id;
    }
    
}