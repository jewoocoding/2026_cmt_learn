package com.example.demo.service;

import com.example.demo.domain.Post;


import java.util.List;

public interface PostService {

    //등록
    Post save(Post post);
    //전체 가져오기
    List<Post>  findAll();
    // 기본키로 읽기
    Post findbyId( long id);
    //수정
    Post update(long id, Post post);
    //데이터 삭제
     void delete(long id);

}
