package com.ctrends.member.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(	name = "member")
@ApiModel(description = "Details about member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "1. The unique id of member")
    private long mId;

    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(notes = "2. Name of a member", required = true)
    private String mName;

    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(notes = "3. Designation of that member", required = true)
    private String designation;

    @NotBlank
    @Size(min = 11,max = 14)
    @ApiModelProperty(notes = "4. Mobile Number of that member", required = true)
    private String mobileNo;

    @NotBlank
    @Size(max = 100)
    @Email
    @ApiModelProperty(notes = "5. Email of that member", required = true)
    private String email;

    @NotNull
    @ApiModelProperty(notes = "6. The id of team", required = true)
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
