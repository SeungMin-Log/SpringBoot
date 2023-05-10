package com.min.Board.service;

import com.min.Board.domain.Member;
import com.min.Board.repository.MemberRepository;
import com.min.Board.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {



    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /* 회원가입 */
    public Long join(Member member){
        validationDuplicateMember(member); //중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validationDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }
    /* 전체 회원 조회 */
    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
