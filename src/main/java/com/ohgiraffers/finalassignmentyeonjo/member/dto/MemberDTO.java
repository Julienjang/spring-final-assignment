package com.ohgiraffers.finalassignmentyeonjo.member.dto;

public class MemberDTO {
    // 강사 코드
    private int memberCode;
    // 강사 이름
    private String memberName;
    // 런칭일
    private String launchDate;
    // 구분 코드
    private String divisionCode;

    // 과목 정보
    private String detailInfo;
    // 수강생 수
    private String studentQuantity;
    // 연락처
    private String contact;
    // 소속 코드
    private String teamCode;
    // 활동 상태
    private String activeStatus;


    // 기본 생성자
    public MemberDTO() {
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

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
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
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberName='" + memberName + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", divisionCode='" + divisionCode + '\'' +
                ", detailInfo='" + detailInfo + '\'' +
                ", studentQuantity='" + studentQuantity + '\'' +
                ", contact='" + contact + '\'' +
                ", teamCode='" + teamCode + '\'' +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }


}