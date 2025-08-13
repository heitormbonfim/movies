package com.movies.controller;


import com.movies.controller.request.StreamingRequest;
import com.movies.controller.response.StreamingResponse;
import com.movies.entity.Streaming;
import com.movies.mapper.StreamingMapper;
import com.movies.service.StreamingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies/streaming")
@RequiredArgsConstructor
public class StreamingController {
    private final StreamingService streamingService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAllStreamings() {
        List<Streaming> streamings = streamingService.findAll();
        List<StreamingResponse> streamingList = streamings.stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();
        return ResponseEntity.ok(streamingList);
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> saveStreaming(@Valid @RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = streamingService.save(newStreaming);
        StreamingResponse streamingSaved = StreamingMapper.toStreamingResponse(savedStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(streamingSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getStreamingById(@PathVariable("id") Long id) {
        Optional<Streaming> optStreaming = streamingService.findById(id);
        if (optStreaming.isPresent()) {
            StreamingResponse streamingFound = StreamingMapper.toStreamingResponse(optStreaming.get());
            return ResponseEntity.ok(streamingFound);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreaming(@PathVariable("id") Long id) {
        streamingService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
