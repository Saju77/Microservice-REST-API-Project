package com.ctrends.member.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(	name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mId;

    @NotBlank
    @Size(max = 100)
    private String mName;

    @NotBlank
    @Size(max = 100)
    private String designation;

    @NotBlank
    @Size(min = 11,max = 14)
    private String mobileNo;

    @NotBlank
    @Size(max = 100)
    @Email
    private String email;

    @NotNull
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
