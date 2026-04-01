package com.example.demo.service.impl;

import com.example.demo.domain.Post;
import com.example.demo.dto.request.PostCreateRequest;
import com.example.demo.dto.request.PostUpdateRequest;
import com.example.demo.dto.response.CommentResponse;
import com.example.demo.dto.response.PostResponse;
import com.example.demo.exception.PostNotFoundException;
import com.example.demo.mapper.PostMapper;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;
    private final CommentService commentService;

    @Override
    @Transactional(readOnly = true)
    public List<PostResponse> getPostList() {
        return postMapper.findAll().stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PostResponse getPost(Long id) {
        Post post = postMapper.findById(id);
        if (post == null) {
            throw new PostNotFoundException(id);
        }
        postMapper.increaseViewCount(id);

        PostResponse response = new PostResponse(post);
        List<CommentResponse> comments = commentService.getCommentsByPostId(id);
        response.setComments(comments);
        return response;
    }

    @Override
    @Transactional
    public void createPost(PostCreateRequest request) {
        postMapper.insert(request);
    }

    @Override
    @Transactional
    public void updatePost(Long id, PostUpdateRequest request) {
        Post post = postMapper.findById(id);
        if (post == null) {
            throw new PostNotFoundException(id);
        }
        postMapper.update(id, request);
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        Post post = postMapper.findById(id);
        if (post == null) {
            throw new PostNotFoundException(id);
        }
        postMapper.delete(id);
    }
}
