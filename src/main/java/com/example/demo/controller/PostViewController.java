package com.example.demo.controller;
import com.example.demo.domain.Post;
import com.example.demo.service.impl.PostServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostViewController {

    @GetMapping("posts/new")
    public String getPostForm() {
        return "post/form";
    }
    @GetMapping("posts/list")
    public String getPostList(Model model) {
        List<Post> posts1 = new ArrayList<Post>();
        for(int i = 0; i < 10; i++)
        {
            Post pp = new Post();
//            pp.setId("test"+i);
//            pp.setTitle("title teset");
//            pp.setAuthor("author teset");
//            pp.setViewCount("view teset");
//            pp.setCreatedAt("2020-01-01");
            posts1.add(pp);
        }

        model.addAttribute("posts", posts1);

        return "post/list";
    }

}
