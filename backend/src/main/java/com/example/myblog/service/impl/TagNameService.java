package com.example.myblog.service.impl;

import com.example.myblog.enity.TagName;
import com.example.myblog.exception.TagNameNotFoundException;
import com.example.myblog.repository.TagNameRepository;
import com.example.myblog.service.ITagNameService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TagNameService implements ITagNameService {
    private final TagNameRepository tagNameRepository;

    public TagNameService(TagNameRepository tagNameRepository) {
        this.tagNameRepository = tagNameRepository;
    }

    @Override
    public List<TagName> findAll() {
        return tagNameRepository.findAll();
    }

    @Override
    public void save(String tagName) {
        TagName tagName1 = new TagName();
        tagName1.setName(tagName);
        tagNameRepository.save(tagName1);
    }
    @Override
    public boolean existByName(String name){
        return tagNameRepository.existsByName(name);
    }
    @Override
    public Set<TagName> findByListName(List<String> list){
        Set<TagName> tagNameSet = new HashSet<>();
        for (String str : list){
            TagName tagName = tagNameRepository.findByName(str);
            if (tagName == null) {
                throw new TagNameNotFoundException("Không tìm thấy");
            } else {
                tagNameSet.add(tagName);
            }
        }
        return tagNameSet;
    }

    @Override
    public void deleteTagName(Long id) {
        tagNameRepository.deleteById(id);
    }

    @Override
    public void updateTagName(Long id) {

    }
}
