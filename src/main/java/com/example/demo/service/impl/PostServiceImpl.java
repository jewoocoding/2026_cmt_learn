package com.example.demo.service.impl;


import com.example.demo.domain.Post;
import com.example.demo.repositories.PostRepository;
import com.example.demo.service.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;

    @Override
    @Transactional
    public Post save(Post post) {
        Post postSave = Post.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .build();

        return postRepository.save(postSave);
    }

    @Override
    @Transactional
    public List<Post> findAll() {

        return postRepository.findAll();
    }

    @Override
    @Transactional
    public Post findbyId(long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("아이디를 찾을수없다"));
    }

    // update
    @Override
    @Transactional
    public Post update(long id, Post post) {
        // 1. 수정할 기존 데이터를 먼저 조회합니다.
        Post postUpdate = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("아이디를 찾을수없다.: " + id));  //?
        postUpdate.setTitle(post.getTitle());
        postUpdate.setContent(post.getContent());


        return postUpdate;
    }

    @Override
    @Transactional
    public void delete(long id) {
       postRepository.deleteById(id);

   }
   @Override
   @Transactional
    public Page<Post> getPostList(Pageable pageable){
            return postRepository.findAll(pageable);

   }

}