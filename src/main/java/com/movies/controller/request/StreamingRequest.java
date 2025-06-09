package com.movies.controller.request;

import lombok.Builder;

@Builder
public record StreamingRequest(String name) {
}
