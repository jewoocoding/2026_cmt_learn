package com.example.demo.service.impl;

import com.example.demo.dto.request.CommentCreateRequest;
import com.example.demo.dto.response.CommentResponse;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CommentResponse> getCommentsByPostId(Long postId) {
        return commentMapper.findByPostId(postId).stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void createComment(CommentCreateRequest request) {
        commentMapper.insert(request);
    }

    @Override
    @Transactional
    public void deleteComment(Long id) {
        commentMapper.delete(id);
    }
}
