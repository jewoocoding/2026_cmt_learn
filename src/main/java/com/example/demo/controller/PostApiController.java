package com.example.demo.controller;

import com.example.demo.dto.request.CommentCreateRequest;
import com.example.demo.dto.request.PostCreateRequest;
import com.example.demo.dto.request.PostUpdateRequest;
import com.example.demo.dto.response.CommentResponse;
import com.example.demo.dto.response.PostResponse;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "게시판 API", description = "게시글 및 댓글 CRUD")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;
    private final CommentService commentService;

    @Operation(summary = "게시글 목록 조회")
    @GetMapping
    public ResponseEntity<List<PostResponse>> getPostList() {
        return ResponseEntity.ok(postService.getPostList());
    }

    @Operation(summary = "게시글 단건 조회")
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(
            @Parameter(description = "게시글 ID") @PathVariable Long id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @Operation(summary = "게시글 작성")
    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostCreateRequest request) {
        postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "게시글 수정")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePost(
            @Parameter(description = "게시글 ID") @PathVariable Long id,
            @RequestBody PostUpdateRequest request) {
        postService.updatePost(id, request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "게시글 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(
            @Parameter(description = "게시글 ID") @PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "댓글 목록 조회")
    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<CommentResponse>> getComments(
            @Parameter(description = "게시글 ID") @PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }

    @Operation(summary = "댓글 작성")
    @PostMapping("/{postId}/comments")
    public ResponseEntity<Void> createComment(
            @Parameter(description = "게시글 ID") @PathVariable Long postId,
            @RequestBody CommentCreateRequest request) {
        commentService.createComment(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @Parameter(description = "게시글 ID") @PathVariable Long postId,
            @Parameter(description = "댓글 ID") @PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
