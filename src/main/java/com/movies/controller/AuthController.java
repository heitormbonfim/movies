package com.movies.controller;

import com.movies.controller.request.UserRequest;
import com.movies.controller.response.UserResponse;
import com.movies.entity.User;
import com.movies.mapper.UserMapper;
import com.movies.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    private ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest) {
        User newUser = userService.save(UserMapper.toUser(userRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(newUser));
    }
}
