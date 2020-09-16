package com.example.projectd.Dto;

public class MemberDTO {
    String member_id;
    String member_pw;
    String nickname;
    String tel;
    String addr;
    String latitude;
    String longitude;
    int grade;
    String member_name;

    public MemberDTO(String member_id, String member_pw, String nickname, String tel, String addr,
                     String latitude, String longitude, int grade, String member_name) {
        this.member_id = member_id;
        this.member_pw = member_pw;
        this.nickname = nickname;
        this.tel = tel;
        this.addr = addr;
        this.latitude = latitude;
        this.longitude = longitude;
        this.grade = grade;
        this.member_name = member_name;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_pw() {
        return member_pw;
    }

    public void setMember_pw(String member_pw) {
        this.member_pw = member_pw;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }
}
