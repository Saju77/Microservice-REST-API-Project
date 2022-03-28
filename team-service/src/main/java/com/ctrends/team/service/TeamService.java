package com.ctrends.team.service;

import com.ctrends.team.models.Team;
import com.ctrends.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team saveTeam(Team team){
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Team updateTeam(Long tmId, Team team){
        team.setTmId(tmId);
        return teamRepository.save(team);
    }

    public void deleteTeam(Long tmId){
        teamRepository.deleteById(tmId);
    }

    public Team getTeamById(Long tmId){
        return teamRepository.findById(tmId).get();
    }

}
