package com.bili.diushoujuaner.model.databasehelper.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "USER".
 */
public class User {

    private Long id;
    private long userNo;
    private String nickName;
    private String mobile;
    private String autograph;
    private Integer gender;
    private String birthday;
    private String homeTown;
    private String location;
    private String picPath;
    private String smallNick;
    private String registTime;
    private String wallPaper;
    private String updateTime;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, long userNo, String nickName, String mobile, String autograph, Integer gender, String birthday, String homeTown, String location, String picPath, String smallNick, String registTime, String wallPaper, String updateTime) {
        this.id = id;
        this.userNo = userNo;
        this.nickName = nickName;
        this.mobile = mobile;
        this.autograph = autograph;
        this.gender = gender;
        this.birthday = birthday;
        this.homeTown = homeTown;
        this.location = location;
        this.picPath = picPath;
        this.smallNick = smallNick;
        this.registTime = registTime;
        this.wallPaper = wallPaper;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserNo() {
        return userNo;
    }

    public void setUserNo(long userNo) {
        this.userNo = userNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getSmallNick() {
        return smallNick;
    }

    public void setSmallNick(String smallNick) {
        this.smallNick = smallNick;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public String getWallPaper() {
        return wallPaper;
    }

    public void setWallPaper(String wallPaper) {
        this.wallPaper = wallPaper;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}
