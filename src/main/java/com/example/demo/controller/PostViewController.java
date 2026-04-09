package com.example.demo.controller;
import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class PostViewController {

    private final PostService postService;

    @GetMapping("/posts")
    public String list(Model model) {
        model.addAttribute("posts", postService.getPostList());
        return "post/list";
    }

    @GetMapping("/posts/new")
    public String newForm() {
        return "post/form";
    }

    @GetMapping("/posts/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("post", postService.getPost(id));
        model.addAttribute("comments", Collections.emptyList());
        return "post/detail";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("post", postService.getPost(id));
        return "post/form";
    }

    @PostMapping("/posts")
    public String create(Post post) {
        post.setViewCount(0);
        postService.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable int id, Post post) {
        post.setId(id);
        postService.modify(post);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable int id) {
        postService.delete(id);
        return "redirect:/posts";
    }
}