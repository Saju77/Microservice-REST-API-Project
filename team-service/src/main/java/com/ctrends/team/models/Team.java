package com.ctrends.team.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tmId;

    @NotBlank
    @Size(max = 100)
    private String tmName;

    @NotBlank
    @Size(max = 150)
    private String projName;

    @NotBlank
    @Size(max = 250)
    private String projDesc;

    @NotBlank
    @Size(max = 50)
    private String tmLeader;

    @NotNull
    @Max(25)
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
