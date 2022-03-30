package com.ctrends.employee.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "employee",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@ApiModel(description = "Details about employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "1. The unique id of employee")
    private Long id;

    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(notes = "2. Full name of an employee", required = true)
    private String empname;

    @NotBlank
    @Size(max = 20)
    @ApiModelProperty(notes = "3. Unique username of an employee", required = true)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    @ApiModelProperty(notes = "4. Unique email of an employee", required = true)
    private String email;

    @NotBlank
    @Size(max = 120)
    @ApiModelProperty(notes = "5. Password of an employee", required = true)
    private String password;

    @Size(max = 100)
    @ApiModelProperty(notes = "6. Designation of an employee")
    private String designation;

    @NotBlank
    @Size(max = 15)
    @ApiModelProperty(notes = "7. Mobile number of an employee")
    private String mobileno;

    @Size(max = 250)
    @ApiModelProperty(notes = "8. Address of an employee")
    private String address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "employee_roles",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ApiModelProperty(notes = "9. List of roles of an employee")
    private Set<Role> roles = new HashSet<>();

    public Employee() {
    }

    public Employee(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Employee(String empname, String username, String email, String password, String designation, String mobileno, String address) {
        this.empname = empname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.designation = designation;
        this.mobileno = mobileno;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
