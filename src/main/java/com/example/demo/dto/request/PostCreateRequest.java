package com.example.demo.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateRequest {

    private String title;
    private String content;
    private String author;
}
