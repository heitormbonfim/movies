package com.movies.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String name, String email) {
}
