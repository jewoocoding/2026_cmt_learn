package com.example.demo.dto.response;

import com.example.demo.domain.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {

    private final Long id;
    private final Long postId;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.postId = comment.getPostId();
        this.content = comment.getContent();
        this.author = comment.getAuthor();
        this.createdAt = comment.getCreatedAt();
    }
}
