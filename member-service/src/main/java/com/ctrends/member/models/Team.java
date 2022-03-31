package com.ctrends.member.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Team {

    private long tmId;
    private String tmName;
    private String tmDetails;
    private String tmActivities;
    private String tmLeader;
    private int totMember;

    public Team() {
    }

    public Team(String tmName, String tmDetails, String tmActivities, String tmLeader, int totMember) {
        this.tmName = tmName;
        this.tmDetails = tmDetails;
        this.tmActivities = tmActivities;
        this.tmLeader = tmLeader;
        this.totMember = totMember;
    }

    public long getTmId() {
        return tmId;
    }

    public void setTmId(long tmId) {
        this.tmId = tmId;
    }

    public String getTmName() {
        return tmName;
    }

    public void setTmName(String tmName) {
        this.tmName = tmName;
    }

    public String getTmDetails() {
        return tmDetails;
    }

    public void setTmDetails(String tmDetails) {
        this.tmDetails = tmDetails;
    }

    public String getTmActivities() {
        return tmActivities;
    }

    public void setTmActivities(String tmActivities) {
        this.tmActivities = tmActivities;
    }

    public String getTmLeader() {
        return tmLeader;
    }

    public void setTmLeader(String tmLeader) {
        this.tmLeader = tmLeader;
    }

    public int getTotMember() {
        return totMember;
    }

    public void setTotMember(int totMember) {
        this.totMember = totMember;
    }
}
