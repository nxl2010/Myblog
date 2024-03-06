package com.example.myblog.service;

import com.example.myblog.enity.Category;

import java.util.List;

public interface ICategoryService {
    <T> List<T> findAll();

    void save(Category category);
}
