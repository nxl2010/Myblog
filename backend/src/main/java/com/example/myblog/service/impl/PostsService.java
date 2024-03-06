package com.example.myblog.service.impl;

import com.example.myblog.dto.request.PostsRequest;
import com.example.myblog.dto.response.PostsResponse;
import com.example.myblog.enity.Posts;
import com.example.myblog.exception.TagNameNotFoundException;
import com.example.myblog.mapstruct.PostsMapper;
import com.example.myblog.repository.PostsRepository;
import com.example.myblog.service.IPostsService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostsService implements IPostsService {
    private final PostsRepository postsRepository;
    private final TagNameService tagNameService;

    public PostsService(PostsRepository postsRepository, TagNameService tagNameService) {
        this.postsRepository = postsRepository;
        this.tagNameService = tagNameService;
    }

    @Override
    public List<PostsResponse> findByCategory(String categoryName) {
        PageRequest pageRequest = PageRequest.of(0,1);
        List<Posts> postsResponses = postsRepository.findByCategoryName(categoryName, pageRequest);
        return PostsMapper.INSTANCE.postsToPostsDto(postsResponses);
    }

    @Override
    public void save(PostsRequest posts) {
        Posts posts1 = PostsMapper.INSTANCE.postDtotoPosts(posts);
        posts1.setTagNames(tagNameService.findByListName(posts.getTagName()));
        posts1.setCreateDate(LocalDateTime.now());
        postsRepository.save(posts1);
    }
    @Override
    public List<PostsResponse> findByTagName(String tagName){
        if (!tagNameService.existByName(tagName)){
            throw new TagNameNotFoundException("Không có tagName này");
        }
        return PostsMapper.INSTANCE.postsToPostsDto(postsRepository.findByTagNames_Name(tagName));
    }

    @Override
    public List<PostsResponse> findByTitleContaining(String keyword) {
        List<Posts> postsList = postsRepository.findByTitleContaining(keyword);
        return PostsMapper.INSTANCE.postsToPostsDto(postsList);
    }
}
