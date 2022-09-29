package com.SecondProject.CricketProject.Entities;

import java.util.List;
public class Cricketer {
    private int id;
    private String name;
    private int age;

//    private Date dob;
//    private List<String> teams;
    private String nickName;
    private String battingStyle;
    private String bowlingStyle;
    private List<Award> awards;
    private String instagramHandle;
    private String imgPath;
    private String about;

    @Override
    public String toString() {
        return "Cricketer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +

                ", nickName='" + nickName + '\'' +
                ", battingStyle='" + battingStyle + '\'' +
                ", bowlingStyle='" + bowlingStyle + '\'' +
                ", awards=" + awards +
                ", instagramHandle='" + instagramHandle + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", about='" + about + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public String getDob() {
//        return dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }

//    public List<String> getTeams() {
//        return teams;
//    }
//
//    public void setTeams(List<String> teams) {
//        this.teams = teams;
//    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBattingStyle() {
        return battingStyle;
    }

    public void setBattingStyle(String battingStyle) {
        this.battingStyle = battingStyle;
    }

    public String getBowlingStyle() {
        return bowlingStyle;
    }

    public void setBowlingStyle(String bowlingStyle) {
        this.bowlingStyle = bowlingStyle;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    public String getInstagramHandle() {
        return instagramHandle;
    }

    public void setInstagramHandle(String instagramHandle) {
        this.instagramHandle = instagramHandle;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

}
