package com.example.demo.mapper;

import com.example.demo.domain.Post;
import com.example.demo.dto.request.PostCreateRequest;
import com.example.demo.dto.request.PostUpdateRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {

    List<Post> findAll();

    Post findById(@Param("id") Long id);

    void insert(PostCreateRequest request);

    void update(@Param("id") Long id, @Param("request") PostUpdateRequest request);

    void delete(@Param("id") Long id);

    void increaseViewCount(@Param("id") Long id);
}
