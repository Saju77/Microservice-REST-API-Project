package com.ctrends.member.controller;

import com.ctrends.member.models.Member;
import com.ctrends.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/members")
@Api(tags = "Member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @ApiOperation(value = "Get all member details",
            notes = "Admin and user both can access this method",
            response = Member.class,
            responseContainer = "List")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Create a member with proper data",
            notes = "This method is only accessible by admin",
            response = Member.class)
    public Member saveMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    @PutMapping("/{mId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Update member details",
            notes = "This method is only accessible by admin",
            response = Member.class)
    public Member updateMember(@PathVariable("mId") Long mId, @RequestBody Member member){
        return memberService.updateMember(mId, member);
    }

    @DeleteMapping("/{mId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Delete a member",
            notes = "This method is only accessible by admin")
    public void deleteMember(@PathVariable("mId") Long mId){
        memberService.deleteMember(mId);
    }

    @GetMapping("/{mId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @ApiOperation(value = "Get a member details by id",
            notes = "Admin and user both can access this method",
            response = Member.class)
    public Member getMemberById(@PathVariable("mId") Long mId){
        return memberService.getMemberById(mId);
    }

    @GetMapping("/team/{tmId}")
    @ApiOperation(value = "Get all members details based on desire team id",
            notes = "This api is created for Team-Service",
            response = Member.class,
            responseContainer = "List")
    public List<Member> getAllMembersByTmId(@PathVariable("tmId") Long tmId){
        return memberService.getAllMembersByTmId(tmId);
    }

}
