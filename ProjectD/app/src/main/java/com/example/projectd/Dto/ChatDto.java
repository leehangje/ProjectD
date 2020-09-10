package com.example.projectd.Dto;

public class ChatDto {
    private String name;
    private String addr;
    private String msg;
    private String photoUrl;

   /*public ChatDto(String name, String addr, String msg){
        this.name = name;
        this.addr = addr;
        this.msg = msg;
    }
*/
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddr(){
        return addr;
    }

    public void getAddr(String addr){
        this.addr = addr;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
