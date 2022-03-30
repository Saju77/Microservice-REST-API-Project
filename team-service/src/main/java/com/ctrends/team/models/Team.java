package com.ctrends.team.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "team")
@ApiModel(description = "Details about team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "1. The unique id of team")
    private long tmId;

    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(notes = "2. Name of a team", required = true)
    private String tmName;

    @NotBlank
    @Size(max = 250)
    @ApiModelProperty(notes = "3. Details/description of that team", required = true)
    private String tmDetails;

    @NotBlank
    @Size(max = 250)
    @ApiModelProperty(notes = "4. Activities of that team", required = true)
    private String tmActivities;

    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(notes = "5. Leader of that team", required = true)
    private String tmLeader;

    @NotNull
    @Max(25)
    @ApiModelProperty(notes = "6. Total number of members", required = true)
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
