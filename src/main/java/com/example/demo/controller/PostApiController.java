package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "게시판 API", description = "게시글 및 댓글 CRUD")
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @Operation(summary = "게시글 목록 조회 API ")
    @GetMapping
    public ResponseEntity<List<Post>> getPostList() {
        return ResponseEntity.ok(postService.getPostList());
    }

    @Operation(summary = "게시글 단건 조회 API ")
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable int id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @Operation(summary = "게시글 등록 API ")
    @PostMapping
    public ResponseEntity<String> insertPost(@RequestBody Post post) {
        int result = postService.save(post);
        return ResponseEntity.ok(result+"");
    }
    @Operation(summary = "게시글 수정 API ")
    @PutMapping("/{id}")
    public ResponseEntity<String> modifyPost(@PathVariable int id, @RequestBody Post post) {
        post.setId(id);
        int result = postService.modify(post);
        return ResponseEntity.ok(result+"");
    }
    @Operation(summary = "게시글 삭제 API ")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id) {
        int result = postService.delete(id);
        return ResponseEntity.ok(result+"");
    }
}

