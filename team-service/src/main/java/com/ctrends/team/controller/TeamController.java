package com.ctrends.team.controller;

import com.ctrends.team.models.Member;
import com.ctrends.team.models.Team;
import com.ctrends.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TeamService teamService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Team saveTeam(@RequestBody Team team){
        return teamService.saveTeam(team);
    }

    @PutMapping("/{tmId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Team updateTeam(@PathVariable("tmId") Long tmId, @RequestBody Team team){
        return teamService.updateTeam(tmId, team);
    }

    @DeleteMapping("/{tmId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteTeam(@PathVariable("tmId") Long tmId){
        teamService.deleteTeam(tmId);
    }

    @GetMapping("/{tmId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Team getTeamById(@PathVariable("tmId") Long tmId){
        return teamService.getTeamById(tmId);
    }

//    @GetMapping("/{tmId}/members")
    @GetMapping("/members")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Member> getAllMembers(){
        System.out.println("hited");
        ResponseEntity<Member[]> response =
                restTemplate.getForEntity(
                        "http://MEMBER-SERVICE/members",
                        Member[].class);
        Member[] members = response.getBody();
        System.out.println("hited2");
        return Arrays.stream(members).collect(Collectors.toList());
    }

//    @GetMapping("/member")
//    public Member getAllMember(){
//        System.out.println("hited");
//        Member member = restTemplate.getForObject("http://MEMBER-SERVICE/members/4", Member.class);
//       return member;
//    }

}
