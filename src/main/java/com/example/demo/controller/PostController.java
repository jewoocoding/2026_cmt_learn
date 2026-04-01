package com.example.demo.controller;

import com.example.demo.dto.request.CommentCreateRequest;
import com.example.demo.dto.request.PostCreateRequest;
import com.example.demo.dto.request.PostUpdateRequest;
import com.example.demo.dto.response.PostResponse;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @GetMapping
    public String list(Model model) {
        List<PostResponse> posts = postService.getPostList();
        model.addAttribute("posts", posts);
        return "post/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        PostResponse post = postService.getPost(id);
        model.addAttribute("post", post);
        return "post/detail";
    }

    @GetMapping("/new")
    public String createForm() {
        return "post/form";
    }

    @PostMapping
    public String create(@ModelAttribute PostCreateRequest request) {
        postService.createPost(request);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        PostResponse post = postService.getPost(id);
        model.addAttribute("post", post);
        return "post/form";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute PostUpdateRequest request) {
        postService.updatePost(id, request);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }

    @PostMapping("/{postId}/comments")
    public String addComment(@PathVariable Long postId, @ModelAttribute CommentCreateRequest request) {
        commentService.createComment(request);
        return "redirect:/posts/" + postId;
    }

    @PostMapping("/{postId}/comments/{commentId}/delete")
    public String deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return "redirect:/posts/" + postId;
    }
}
