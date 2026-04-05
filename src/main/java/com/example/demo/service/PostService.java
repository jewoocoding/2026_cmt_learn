package com.example.demo.service;

import com.example.demo.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public List<Post> getPostList();
    public Post getPost(int id);
    public int save(Post post);
    public int modify(Post post);
    public int delete(int id);
}
