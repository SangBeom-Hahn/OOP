package com.example.demo.user.service;

import com.example.demo.mock.FakeMailSender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CertificationServiceTest {
    @Test
    @DisplayName("")
    void CertificationServiceTest() {
        // given
        FakeMailSender fakeMailSender = new FakeMailSender();
        CertificationService certificationService =
                new CertificationService(fakeMailSender);

        // when
        certificationService.send("a@naver.com", 1, "aaaa");
      
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