package com.example.demo.service;

import com.example.demo.dto.request.PostCreateRequest;
import com.example.demo.dto.request.PostUpdateRequest;
import com.example.demo.dto.response.PostResponse;

import java.util.List;

public interface PostService {

    List<PostResponse> getPostList();

    PostResponse getPost(Long id);

    void createPost(PostCreateRequest request);

    void updatePost(Long id, PostUpdateRequest request);

    void deletePost(Long id);
}
