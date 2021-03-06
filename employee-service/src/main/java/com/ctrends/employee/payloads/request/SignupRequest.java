package com.ctrends.employee.payloads.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

import javax.validation.constraints.*;

@ApiModel(description = "Details about employee's signupRequest")
public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    @ApiModelProperty(notes = "1. Full name of an employee", required = true)
    private String empname;

    @NotBlank
    @Size(min = 3, max = 20)
    @ApiModelProperty(notes = "2. Unique username of an employee", required = true)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    @ApiModelProperty(notes = "3. Unique email of an employee", required = true)
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    @ApiModelProperty(notes = "4. Password of an employee", required = true)
    private String password;

    @ApiModelProperty(notes = "5. List of roles of an employee")
    private Set<String> role;

    @NotBlank
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

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
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

    public void setMobileNo(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
