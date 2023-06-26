package com.ohgiraffers.finalassignmentyeonjo.team.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM_INFO")
public class Team {

    @Id
    @Column(name = "TEAM_CODE")
    private Integer teamCode;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @Column(name = "TEAM_DETAIL")
    private String teamDetail;

    @Column(name = "USE_YN")
    private String useYn;

    public Team() {
    }

    public Team(Integer teamCode, String teamName, String teamDetail, String useYn) {
        this.teamCode = teamCode;
        this.teamName = teamName;
        this.teamDetail = teamDetail;
        this.useYn = useYn;
    }

    // Getters and Setters

    public Integer getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(Integer teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDetail() {
        return teamDetail;
    }

    public void setTeamDetail(String teamDetail) {
        this.teamDetail = teamDetail;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamCode=" + teamCode +
                ", teamName='" + teamName + '\'' +
                ", teamDetail='" + teamDetail + '\'' +
                ", useYn='" + useYn + '\'' +
                '}';
    }
}
