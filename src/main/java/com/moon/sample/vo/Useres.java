package com.moon.sample.vo;

import java.io.Serializable;

public class Useres implements Serializable{

    private String userid;
    private String name;
    private String nickname;

    public Useres() {
    }

    public Useres(String userid, String name, String nickname) {
        this.userid = userid;
        this.name = name;
        this.nickname = nickname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Useres{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
