package com.example.thecodetest.mockito.study;

import com.example.thecodetest.mockito.domain.Member;
import com.example.thecodetest.mockito.domain.Study;
import com.example.thecodetest.mockito.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {
    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    @DisplayName("")
    void StudyServiceTest() {
        // given
        StudyService studyService = new StudyService(memberService, studyRepository);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("hsb");

        Study study = new Study();

        // 스터빙 모음 -> 목 2.x부터 스터빙은 메서드에 하나만 하도록 했다. 다른 목 객체가 2개여도 무조건 1번만 일어나도록 한다.
        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(member.getId(), study);

        verify(memberService, times(1)).notify(study);
        verifyNoMoreInteractions(memberService);
    }
}