package com.bili.diushoujuaner.model.databasehelper.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "CHAT".
 */
public class Chat {

    private Long id;
    private long ownerNo;
    private long fromNo;
    private long toNo;
    private String content;
    /** Not-null value. */
    private java.util.Date time;
    private int msgType;
    private int conType;

    public Chat() {
    }

    public Chat(Long id) {
        this.id = id;
    }

    public Chat(Long id, long ownerNo, long fromNo, long toNo, String content, java.util.Date time, int msgType, int conType) {
        this.id = id;
        this.ownerNo = ownerNo;
        this.fromNo = fromNo;
        this.toNo = toNo;
        this.content = content;
        this.time = time;
        this.msgType = msgType;
        this.conType = conType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getOwnerNo() {
        return ownerNo;
    }

    public void setOwnerNo(long ownerNo) {
        this.ownerNo = ownerNo;
    }

    public long getFromNo() {
        return fromNo;
    }

    public void setFromNo(long fromNo) {
        this.fromNo = fromNo;
    }

    public long getToNo() {
        return toNo;
    }

    public void setToNo(long toNo) {
        this.toNo = toNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /** Not-null value. */
    public java.util.Date getTime() {
        return time;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public int getConType() {
        return conType;
    }

    public void setConType(int conType) {
        this.conType = conType;
    }

}