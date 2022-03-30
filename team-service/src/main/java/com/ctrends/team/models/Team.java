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
    @Size(max = 150)
    @ApiModelProperty(notes = "3. Project Name of a team", required = true)
    private String projName;

    @NotBlank
    @Size(max = 250)
    @ApiModelProperty(notes = "4. Description of that project", required = true)
    private String projDesc;

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

    public Team(String tmName, String projName, String projDesc, String tmLeader, int totMember) {
        this.tmName = tmName;
        this.projName = projName;
        this.projDesc = projDesc;
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

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjDesc() {
        return projDesc;
    }

    public void setProjDesc(String projDesc) {
        this.projDesc = projDesc;
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
