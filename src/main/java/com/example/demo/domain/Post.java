package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Long id;
    private String title;
    private String content;
    private String author;
    private int viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}