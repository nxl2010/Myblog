package com.example.myblog.mapstruct;

import com.example.myblog.dto.request.PostsRequest;
import com.example.myblog.dto.response.PostsResponse;
import com.example.myblog.enity.Posts;
import com.example.myblog.enity.TagName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface PostsMapper {
    PostsMapper INSTANCE = Mappers.getMapper(PostsMapper.class);
    @Mapping(target = "content", ignore = true)
    @Mapping(source = "tagNames", target = "tagNames")
    List<PostsResponse> postsToPostsDto(List<Posts> posts);
    default Set<String> mapTagNamesToStrings(Set<TagName> tagNames) {
        return tagNames.stream()
                .map(TagName::getName)
                .collect(Collectors.toSet());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "likes", expression = "java(0)")
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "category.id", source = "categoryId")
    Posts postDtotoPosts (PostsRequest postsRequest);

}
