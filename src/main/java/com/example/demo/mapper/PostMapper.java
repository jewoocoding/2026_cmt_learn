package com.example.demo.mapper;

import com.example.demo.domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    public List<Post> findAll();
    public Post findOne(int id);
    public int save(Post post);
    public int modify(Post post);
    public int delete(int id);
}
