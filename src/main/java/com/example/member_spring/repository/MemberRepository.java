package com.example.member_spring.repository;

import com.example.member_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // Member 를 다 조회(R)
    List<Member> findAll();
    // 새로운 member 등록(C)
    Member save(Member member);
    // id로 고객 정보 리턴(없다면 Optional)
    Optional<Member> findById(Long id);
    // id 받아서 삭제 (D)
    void deleteById(Long id);

}
