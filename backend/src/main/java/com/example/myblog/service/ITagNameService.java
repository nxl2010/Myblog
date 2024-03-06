package com.example.myblog.service;

import com.example.myblog.enity.TagName;

import java.util.List;
import java.util.Set;

public interface ITagNameService {
    <T> List<T> findAll();
    void save(String tagName);
    void deleteTagName(Long id);
    Set<TagName> findByListName(List<String> list);
    boolean existByName(String name);

    void updateTagName(Long id);
}
