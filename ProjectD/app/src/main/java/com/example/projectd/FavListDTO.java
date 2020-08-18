package com.example.projectd;

public class FavListDTO {
    String md_name;
    String member_nickname;

    public FavListDTO(String md_name, String member_nickname) {
        this.md_name = md_name;
        this.member_nickname = member_nickname;
    }

    public String getMd_name() {
        return md_name;
    }

    public void setMd_name(String md_name) {
        this.md_name = md_name;
    }

    public String getMember_nickname() {
        return member_nickname;
    }

    public void setMember_nickname(String member_nickname) {
        this.member_nickname = member_nickname;
    }
}

