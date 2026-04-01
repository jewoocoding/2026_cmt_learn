package com.example.demo.mapper;

import com.example.demo.domain.Comment;
import com.example.demo.dto.request.CommentCreateRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<Comment> findByPostId(@Param("postId") Long postId);

    void insert(CommentCreateRequest request);

    void delete(@Param("id") Long id);
}
