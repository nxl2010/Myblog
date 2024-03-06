package com.example.myblog.repository;

import com.example.myblog.enity.Posts;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    List<Posts> findByCategoryName(String categoryName, PageRequest pageRequest);
    List<Posts> findByTitleContaining(String keyword);
    List<Posts> findByTagNames_Name(String tagName);
}
