package com.example.demo.user.controller;

import com.example.demo.service.UserServiceImpl;
import com.example.demo.user.domain.UserCreate;
import com.example.demo.user.controller.response.UserResponse;
import com.example.demo.user.infrastructure.UserEntity;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "유저(users)")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserCreateController {

    private final UserController userController;
    private final UserServiceImpl userServiceImpl;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreate userCreateDto) {
        UserEntity user = userServiceImpl.create(userCreateDto);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userController.toResponse(user));
    }

}