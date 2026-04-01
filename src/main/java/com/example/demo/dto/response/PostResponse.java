package com.example.demo.dto.response;

import com.example.demo.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final int viewCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private List<CommentResponse> comments;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.viewCount = post.getViewCount();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
    }

    public void setComments(List<CommentResponse> comments) {
        this.comments = comments;
    }
}
