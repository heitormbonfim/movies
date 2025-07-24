package com.movies.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class GlobalController {
    @GetMapping("/health")
    public ResponseEntity<String> alive() {
        return ResponseEntity.ok("Alive");
    }
}
