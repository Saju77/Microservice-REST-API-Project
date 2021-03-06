package com.ctrends.member.service;

import com.ctrends.member.models.Member;
import com.ctrends.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member updateMember(Long mId, Member member){
        member.setmId(mId);
        return memberRepository.save(member);
    }

    public void deleteMember(Long mId){
        memberRepository.deleteById(mId);
    }

    public Member getMemberById(Long mId){
        return memberRepository.findById(mId).get();
    }

    public List<Member> getAllMembersByTmId(Long tmId){ return memberRepository.getAllMembersByTmId(tmId);}

}
