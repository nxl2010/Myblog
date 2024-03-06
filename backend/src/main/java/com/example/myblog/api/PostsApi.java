package com.example.myblog.api;

import com.example.myblog.dto.request.PostsRequest;
import com.example.myblog.dto.response.PostsResponse;
import com.example.myblog.exception.TagNameNotFoundException;
import com.example.myblog.service.impl.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/posts")
public class PostsApi {
    @Autowired
    private PostsService postsService;

    @GetMapping("/{category}")
    public List<PostsResponse> findByCategory(@PathVariable String category){
        return postsService.findByCategory(category);

    }
    @GetMapping("/findByTagName")
    public ResponseEntity<List<PostsResponse>> findByTagName(@RequestParam String tagName) {
        try {
            List<PostsResponse> posts = postsService.findByTagName(tagName);
            return ResponseEntity.ok(posts);
        } catch (TagNameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> addByCategory(@RequestBody PostsRequest posts){
        try {
            postsService.save(posts);
            return ResponseEntity.ok().body("Okk baby");
        } catch (TagNameNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
    }
    @GetMapping
    public List<PostsResponse> searchKeyword(@RequestParam String keyword){
        List<PostsResponse> postsResponse = postsService.findByTitleContaining(keyword);
        return postsResponse;
    }
}
