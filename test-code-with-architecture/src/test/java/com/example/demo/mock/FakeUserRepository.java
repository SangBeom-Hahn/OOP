package com.example.demo.mock;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserStatus;
import com.example.demo.user.service.port.UserRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class FakeUserRepository implements UserRepository {
    private final AtomicLong autoGenerateId = new AtomicLong(0);
    private final List<User> data = Collections.synchronizedList(new ArrayList<>());

    @Override
    public Optional<User> findByIdAndStatus(long id, UserStatus userStatus) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmailAndStatus(String email, UserStatus userStatus) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        if (user.getId() == 0 || user.getId() == null) {
            User newUser = User.builder()
                    .id(autoGenerateId.incrementAndGet())
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .address(user.getAddress())
                    .status(UserStatus.PENDING)
                    .certificationCode(user.getCertificationCode())
                    .lastLoginAt(user.getLastLoginAt())
                    .build();
            data.add(newUser);
            return newUser;
        } else {
            data.removeIf(item -> Objects.equals(item.getId(), user.getId()));
            data.add(user);
            return user;
        }
    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.empty();
    }
}
