package com.example.thecodetest.mockito.study;

import com.example.thecodetest.mockito.domain.Member;
import com.example.thecodetest.mockito.domain.Study;
import com.example.thecodetest.mockito.member.MemberService;

import java.util.Optional;

public class StudyService {
    private final MemberService memberService;

    private final StudyRepository repository;

    public StudyService(MemberService memberService, StudyRepository repository) {
        assert memberService != null;
        assert repository != null;
        this.memberService = memberService;
        this.repository = repository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Optional<Member> member = memberService.findById(memberId);
        if (member.isEmpty()) {
            throw new IllegalArgumentException("Member doesn't exist for id: '" + memberId + "'");
        }
        study.setOwnerId(memberId);
        Study saveStudy = repository.save(study);

        memberService.notify(saveStudy);
        return saveStudy;
    }
}
