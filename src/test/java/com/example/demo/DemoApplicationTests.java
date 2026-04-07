package com.example.demo;

import com.example.demo.domain.Post;
import com.example.demo.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {



    @Autowired
    PostRepository postRepository;

    @Test
    void contextLoads() {


 List<Post> Post = postRepository.findAll();

        for (Post post: Post){
            System.out.println(post.getTitle());
        }



   }


}
