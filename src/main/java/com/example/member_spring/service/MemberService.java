package com.example.member_spring.service;

import com.example.member_spring.domain.Member;
import com.example.member_spring.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //회원가입
    public Long join(Member member) {
        validateDuplicateMember(member);
        //실제 저장은 Repository가 수행
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findAll().stream()
                .filter(p -> p.getName().equals(member.getName()))
                .findAny()
                .ifPresent(p -> {
                    throw new IllegalStateException("이미 존재하는 회원");
                });
    }
    public Member findById(Long id){
        return memberRepository.findById(id).orElse(null);
    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }
    public void update(Long id, String name, int age){
        Member member = memberRepository.findById(id)
                        .orElseThrow(()-> new IllegalArgumentException("해당 아이디 없습니다."));
        member.setName(name);
        member.setAge(age);


    }
}
