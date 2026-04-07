package com.example.demo.Dto;

import com.example.demo.domain.Post;

public class PostResponseDto {

    private String title;
    private String content;
    private String author;

    public PostResponseDto(Post post){
    //    this.title = post.getTitle();
        this.content =post.getContent();
        this.author = post. getAuthor();
    }

}
