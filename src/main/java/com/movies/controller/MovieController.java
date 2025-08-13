package com.movies.controller;

import com.movies.controller.request.MovieRequest;
import com.movies.controller.response.MovieResponse;
import com.movies.entity.Movie;
import com.movies.mapper.MovieMapper;
import com.movies.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request) {
        Movie savedMovie = movieService.save(MovieMapper.toMovie(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {
        return ResponseEntity.ok(movieService.findAll()
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findMovieById(@PathVariable("id") Long id) {
        return movieService.findMovieById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id,@Valid @RequestBody MovieRequest request) {
        return movieService.update(id, MovieMapper.toMovie(request))
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findMoviesByCategory(@RequestParam Long category) {
        List<Movie> moviesByCategory = movieService.findMoviesByCategory(category);
        return ResponseEntity.ok(
                moviesByCategory.stream().map(MovieMapper::toMovieResponse).toList()
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
