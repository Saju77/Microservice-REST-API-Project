package com.ctrends.member.repository;

import com.ctrends.member.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> getAllMembersByTmId(Long tmId);
}
