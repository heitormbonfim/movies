package com.movies.controller.request;

public record UserRequest(
        String name,
        String email,
        String password
) {

}
