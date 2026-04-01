package com.example.demo.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentCreateRequest {

    private Long postId;
    private String content;
    private String author;
}
