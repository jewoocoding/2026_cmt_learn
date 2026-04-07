package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 1. 게시글 전체 목록 화면
    @GetMapping
    public String list(Model model, @PageableDefault(sort = "id",
            direction = Sort.Direction.DESC) Pageable pageable) {

        // 1. 서비스에 pageable을 전달해서 딱 3개만 담긴 Page 객체를 받습니다.
        Page<Post> postPage = postService.getPostList(pageable);

        // 2. HTML에 Page 객체를 통째로 넘깁니다.
        model.addAttribute("posts", postPage);

        return "post/list";
    }

    // 2. 게시글 상세 조회 화면
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Post post = postService.findbyId(id);
        model.addAttribute("post", post);
        return "post/detail";
    }

    // 3. 게시글 등록 화면 (Form)
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/form";
    }

    // 4. 게시글 등록 처리  왜 안죄지? 맞는데이거? 델값에 넣는거자나 왜안되는거임?
    @PostMapping()
    public String create(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts";
    }

    // 5. 게시글 수정 화면
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Post post = postService.findbyId(id);
        model.addAttribute("post", post);
        return "post/form";
    }

    // 6. 게시글 수정 처리
    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute Post post) {
        postService.update(id, post);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable Long id){
        postService.delete(id);
        return "redirect:/posts";
    }
}