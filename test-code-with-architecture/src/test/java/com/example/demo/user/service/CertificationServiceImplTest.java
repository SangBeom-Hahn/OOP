package com.example.demo.user.service;

import com.example.demo.mock.FakeMailSender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CertificationServiceImplTest {
    @Test
    @DisplayName("")
    void CertificationServiceTest() {
        // given
        FakeMailSender fakeMailSender = new FakeMailSender();
        CertificationServiceImpl certificationServiceImpl =
                new CertificationServiceImpl(fakeMailSender);

        // when
        certificationServiceImpl.send("a@naver.com", 1, "aaaa");
      
        // then
        assertThat(fakeMailSender.email)
                .isEqualTo("a@naver.com");
        assertThat(fakeMailSender.title)
                .isEqualTo("Please certify your email address");
        assertThat(fakeMailSender.content)
                .isEqualTo(
                        "Please click the following link to certify your email address: http://localhost:8080/api/users/1/verify?certificationCode=aaaa"
                );
    }
}