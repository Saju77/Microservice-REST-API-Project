package com.ctrends.member.controller;

import com.ctrends.member.model.Member;
import com.ctrends.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @PostMapping
    public Member saveMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    @PutMapping("/{mId}")
    public Member updateMember(@PathVariable("mId") Long mId, @RequestBody Member member){
        return memberService.updateMember(mId, member);
    }

    @DeleteMapping("/{mId}")
    public void deleteProduct(@PathVariable("mId") Long mId){
        memberService.deleteMember(mId);
    }

    @GetMapping("/{mId}")
    public Member getProductById(@PathVariable("mId") Long mId){
        return memberService.getMemberById(mId);
    }

}
