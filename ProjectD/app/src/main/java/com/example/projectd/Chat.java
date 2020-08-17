package com.example.projectd;

public class Chat {
    String name;
    String addr;

    public Chat(String name, String addr){
        this.name = name;
        this.addr = addr;
    }

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

}
