package com.example.thecodetest.mockito.member;

import com.example.thecodetest.mockito.domain.Member;
import com.example.thecodetest.mockito.domain.Study;

import java.util.Optional;

public interface MemberService {
    Optional<Member> findById(Long memberId);

    void validate(Long id);

    void notify(Study study);

    void notify(Member member);
}

