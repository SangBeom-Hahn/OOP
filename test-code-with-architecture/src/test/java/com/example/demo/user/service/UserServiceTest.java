package com.example.demo.user.service;


import com.example.demo.mock.FakeMailSender;
import com.example.demo.mock.FakeUserRepository;
import com.example.demo.mock.TestClockHolder;
import com.example.demo.mock.TestUuidHolder;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void init() {
        FakeMailSender fakeMailSender = new FakeMailSender();
        this.userService = UserService.builder()
                .clockHolder(new TestClockHolder(1))
                .userRepository(new FakeUserRepository())
                .uuidHolder(new TestUuidHolder("aaaa"))
                .certificationService(new CertificationService(fakeMailSender))
                .build();
    }
}
