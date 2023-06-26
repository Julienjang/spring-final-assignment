package com.ohgiraffers.finalassignmentyeonjo.team.dto;

import java.io.Serializable;

public class TeamDTO implements Serializable {

    private Integer teamCode;
    private String teamName;
    private String teamDetail;
    private String useYn;

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
        return "TeamDTO{" +
                "teamCode=" + teamCode +
                ", teamName='" + teamName + '\'' +
                ", teamDetail='" + teamDetail + '\'' +
                ", useYn='" + useYn + '\'' +
                '}';
    }
}
