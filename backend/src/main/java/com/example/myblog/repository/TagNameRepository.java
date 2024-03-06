package com.example.myblog.repository;

import com.example.myblog.enity.TagName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagNameRepository extends JpaRepository<TagName,Long> {
    TagName findByName(String name);
    boolean existsByName(String name);
    void delete(TagName entity);
}
