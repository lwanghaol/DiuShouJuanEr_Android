package com.bili.diushoujuaner.utils.entity.po;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "APPLY".
 */
public class Apply {

    private Long id;
    private long ownerNo;
    private long fromNo;
    private long toNo;
    private String content;
    private String time;
    private Integer type;
    private Boolean read;
    private Boolean accept;

    public Apply() {
    }

    public Apply(Long id) {
        this.id = id;
    }

    public Apply(Long id, long ownerNo, long fromNo, long toNo, String content, String time, Integer type, Boolean read, Boolean accept) {
        this.id = id;
        this.ownerNo = ownerNo;
        this.fromNo = fromNo;
        this.toNo = toNo;
        this.content = content;
        this.time = time;
        this.type = type;
        this.read = read;
        this.accept = accept;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Boolean getAccept() {
        return accept;
    }

    public void setAccept(Boolean accept) {
        this.accept = accept;
    }

}