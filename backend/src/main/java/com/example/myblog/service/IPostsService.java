package com.example.myblog.service;

import com.example.myblog.dto.request.PostsRequest;

import java.util.List;

public interface IPostsService {
    <T> List<T> findByCategory(String categoryName);
    void save(PostsRequest posts);
    <T> List<T> findByTagName(String tagName);
    <T> List<T> findByTitleContaining(String keyword);
}
