package com.example.demo.domain;

import com.example.demo.mock.TestUuidHolder;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserCreate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    @DisplayName("")
    void UserTest() {
        // given
        UserCreate userCreate = UserCreate.builder()
                .email("123")
                .nickname("123")
                .address("123")
                .build();

        // when
        User user = User.from(userCreate, new TestUuidHolder("aaaa"));

        // then
        Assertions.assertThat(user.getCertificationCode()).isEqualTo("aaaa");
    }
}
