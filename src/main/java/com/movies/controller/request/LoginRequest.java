package com.movies.controller.request;

public record LoginRequest(
        String email,
        String password
) {
}
