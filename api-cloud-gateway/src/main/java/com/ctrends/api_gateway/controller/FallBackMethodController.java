package com.ctrends.api_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/employeeServiceFallBack")
    public String employeeServiceFallBackMethod(){
        return "Employee Service is taking longer than expected."+
                " Please try again later.";
    }

    @GetMapping("/teamServiceFallBack")
    public String teamServiceFallBackMethod(){
        return "Team Service is taking longer than expected."+
                " Please try again later.";
    }

    @GetMapping("/memberServiceFallBack")
    public String memberServiceFallBackMethod(){
        return "Member Service is taking longer than expected."+
                " Please try again later.";
    }

}
