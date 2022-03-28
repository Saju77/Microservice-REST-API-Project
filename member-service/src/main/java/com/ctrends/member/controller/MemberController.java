package com.ctrends.member.controller;

import com.ctrends.member.models.Member;
import com.ctrends.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Member saveMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    @PutMapping("/{mId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Member updateMember(@PathVariable("mId") Long mId, @RequestBody Member member){
        return memberService.updateMember(mId, member);
    }

    @DeleteMapping("/{mId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable("mId") Long mId){
        memberService.deleteMember(mId);
    }

    @GetMapping("/{mId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Member getProductById(@PathVariable("mId") Long mId){
        return memberService.getMemberById(mId);
    }

}
