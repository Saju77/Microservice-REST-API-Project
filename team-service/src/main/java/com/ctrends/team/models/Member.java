package com.ctrends.team.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about member")
public class Member {

    @ApiModelProperty(notes = "1. The unique id of member")
    private long mId;

    @ApiModelProperty(notes = "2. Name of a member", required = true)
    private String mName;

    @ApiModelProperty(notes = "3. Designation of that member")
    private String designation;

    @ApiModelProperty(notes = "4. Mobile Number of that member")
    private String mobileNo;

    @ApiModelProperty(notes = "5. Email of that member")
    private String email;

    @ApiModelProperty(notes = "6. The id of team")
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
