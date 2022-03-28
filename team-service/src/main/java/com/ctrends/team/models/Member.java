package com.ctrends.team.models;

public class Member {

    private long mId;
    private String mName;
    private String designation;
    private String mobileNo;
    private String email;
    private long tmId;

    public Member() {
    }

    public Member(String mName, String designation, String mobileNo, String email, long tmId) {
        this.mName = mName;
        this.designation = designation;
        this.mobileNo = mobileNo;
        this.email = email;
        this.tmId = tmId;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTmId() {
        return tmId;
    }

    public void setTmId(long tmId) {
        this.tmId = tmId;
    }
}
