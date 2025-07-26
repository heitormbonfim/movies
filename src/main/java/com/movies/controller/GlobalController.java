package com.movies.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class GlobalController {
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> alive() {
        Map<String, String> response = Map.of("message", "Alive");
        return ResponseEntity.ok(response);
    }
}
