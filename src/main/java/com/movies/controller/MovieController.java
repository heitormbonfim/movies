package com.movies.controller;

import com.movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;


}
