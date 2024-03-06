package com.example.myblog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsResponse {
    private Long id;
    private String title;
    private String description;
    private int likes;
    private LocalDateTime createDate;
    private Set<String> tagNames;

}
