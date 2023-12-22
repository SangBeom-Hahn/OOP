package com.example.demo.user.service;


import com.example.demo.mock.FakeMailSender;
import com.example.demo.mock.FakeUserRepository;
import com.example.demo.mock.TestClockHolder;
import com.example.demo.mock.TestUuidHolder;
import com.example.demo.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;

public class UserServiceImplTest {
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    void init() {
        FakeMailSender fakeMailSender = new FakeMailSender();
        this.userServiceImpl = UserServiceImpl.builder()
                .clockHolder(new TestClockHolder(1))
                .userRepository(new FakeUserRepository())
                .uuidHolder(new TestUuidHolder("aaaa"))
                .certificationServiceImpl(new CertificationServiceImpl(fakeMailSender))
                .build();
    }
}
