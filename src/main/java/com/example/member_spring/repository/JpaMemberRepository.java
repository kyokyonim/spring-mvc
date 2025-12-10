package com.example.member_spring.repository;

import com.example.member_spring.domain.Member;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository {
    private final EntityManager em;
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m",Member.class).getResultList();
    }
    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }
    @Override
    public Optional<Member> findById(Long id){
        return Optional.ofNullable(em.find(Member.class, id));
    }
    @Override
    //없으면
    public void deleteById(Long id) {
        Member delete = em.find(Member.class, id);
        if(delete == null) {
            new IllegalArgumentException("삭제할 멤버가 없습니다.");
        }
        em.remove(delete);
    }

}
