package com.example.demo.service.impl;

import com.example.demo.domain.Post;
import com.example.demo.mapper.PostMapper;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostMapper postMapper;

    public List<Post> getPostList() {
        return postMapper.findAll();
    }

    public Post getPost(int id)
    {
        Post post = postMapper.findOne(id);
        return post;
    }

    public int save(Post post)
    {
        return postMapper.save(post);
    }
    public int modify(Post post)
    {
        return postMapper.modify(post);
    }
    public int delete(int id)
    {
        return postMapper.delete(id);
    }
}

