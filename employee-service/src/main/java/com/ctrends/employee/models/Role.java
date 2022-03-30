package com.ctrends.employee.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@ApiModel(description = "Details about roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "1. The unique id of role")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @ApiModelProperty(notes = "2. The name of role")
    private ERole name;

    public Role() {
    }
    public Role(ERole name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}