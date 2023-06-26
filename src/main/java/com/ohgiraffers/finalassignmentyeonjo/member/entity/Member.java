package com.ohgiraffers.finalassignmentyeonjo.member.entity;

import com.ohgiraffers.finalassignmentyeonjo.team.entity.Team;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER_INFO")
public class Member {

    @Id
    @Column(name = "MEMBER_CODE")
    private int memberCode;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "LAUNCH_DATE")
    private String launchDate;

    @Column(name = "DIVISION_CODE")
    private String divisionCode;

    @Column(name = "DETAIL_INFO")
    private String detailInfo;

    @Column(name = "STUDENT_QUANTITY")
    private String studentQuantity;

    @Column(name = "CONTACT")
    private String contact;

    @JoinColumn(name = "TEAM_CODE")
    @ManyToOne
    private Team teamCode;

    @Column(name = "ACTIVE_STATUS")
    private String activeStatus;

    public Member() {}

    public Member(int memberCode, String memberName, String launchDate, String divisionCode, String detailInfo, String studentQuantity, String contact, Team teamCode, String activeStatus) {
        this.memberCode = memberCode;
        this.memberName = memberName;
        this.launchDate = launchDate;
        this.divisionCode = divisionCode;
        this.detailInfo = detailInfo;
        this.studentQuantity = studentQuantity;
        this.contact = contact;
        this.teamCode = teamCode;
        this.activeStatus = activeStatus;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getStudentQuantity() {
        return studentQuantity;
    }

    public void setStudentQuantity(String studentQuantity) {
        this.studentQuantity = studentQuantity;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Team getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(Team teamCode) {
        this.teamCode = teamCode;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberCode=" + memberCode +
                ", memberName='" + memberName + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", divisionCode='" + divisionCode + '\'' +
                ", detailInfo='" + detailInfo + '\'' +
                ", studentQuantity='" + studentQuantity + '\'' +
                ", contact='" + contact + '\'' +
                ", teamCode=" + teamCode +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }
}

