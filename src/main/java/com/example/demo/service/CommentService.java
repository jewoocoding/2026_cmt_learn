package com.example.demo.service;

import com.example.demo.dto.request.CommentCreateRequest;
import com.example.demo.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {

    List<CommentResponse> getCommentsByPostId(Long postId);

    void createComment(CommentCreateRequest request);

    void deleteComment(Long id);
}
