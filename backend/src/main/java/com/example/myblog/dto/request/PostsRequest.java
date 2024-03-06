package com.example.myblog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsRequest {
      private String title;
      private String description;
      private String content;
      private Long categoryId;
      private List<String> tagName;
}
