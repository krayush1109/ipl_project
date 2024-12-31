package com.wecp.progressive.entity;

import javax.persistence.*;

// public class Team {
@Entity
public class Team implements Comparable<Team> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int teamId;
    String teamName;
    String location;
    String ownerName;
    int establishmentYear;    

    public Team (){}

    public Team(int teamId, String teamName, String location, String ownerName, int establishmentYear) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.location = location;
        this.ownerName = ownerName;
        this.establishmentYear = establishmentYear;
    }    

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    @Override
    public int compareTo(Team that){
        return this.teamName.compareTo(that.teamName);
    }
    

}