package com.ctrends.team.controller;

import com.ctrends.team.models.Member;
import com.ctrends.team.models.Team;
import com.ctrends.team.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/teams")
@Api( tags = "Team")
public class TeamController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TeamService teamService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @ApiOperation(value = "Get all team details",
                    notes = "Admin and user both can access this method",
                    response = Team.class,
                    responseContainer = "List")
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Create a team with proper data",
                    notes = "This method is only accessible by admin",
                    response = Team.class)
    public Team saveTeam(@RequestBody Team team){
        return teamService.saveTeam(team);
    }

    @PutMapping("/{tmId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Update team details",
            notes = "This method is only accessible by admin",
            response = Team.class)
    public Team updateTeam(@PathVariable("tmId") Long tmId, @RequestBody Team team){
        return teamService.updateTeam(tmId, team);
    }

    @DeleteMapping("/{tmId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Delete a team",
            notes = "This method is only accessible by admin")
    public void deleteTeam(@PathVariable("tmId") Long tmId){
        teamService.deleteTeam(tmId);
    }

    @GetMapping("/{tmId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @ApiOperation(value = "Get a team details by id",
            notes = "Admin and user both can access this method",
            response = Team.class)
    public Team getTeamById(@PathVariable("tmId") Long tmId){
        return teamService.getTeamById(tmId);
    }

    @GetMapping("/tmId/{tmId}")
    @ApiOperation(value = "Get a team details by id",
            notes = "This api is used for members-service",
            response = Team.class)
    public Team getTeamByIdForMembers(@PathVariable("tmId") Long tmId){
        return teamService.getTeamById(tmId);
    }

    @GetMapping("/{tmId}/members")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @ApiOperation(value = "Get all members details based on desire team id",
                    notes = "Admin and user both can access this method",
                    response = Team.class,
                    responseContainer = "List")
    public List<Member> getAllMembersByTmId(@PathVariable("tmId") Long tmId){
        ResponseEntity<Member[]> response =
                restTemplate.getForEntity(
                        "http://MEMBER-SERVICE/members/team/"+tmId,
                        Member[].class);
        Member[] members = response.getBody();
        return Arrays.stream(members).collect(Collectors.toList());
    }
}
