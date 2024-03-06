package com.example.myblog.api;

import com.example.myblog.enity.TagName;
import com.example.myblog.service.impl.TagNameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/tagname")
public class TagNameApi {
    private final TagNameService tagNameService;

    public TagNameApi(TagNameService tagNameService) {
        this.tagNameService = tagNameService;
    }

    @GetMapping
    public List<TagName> findAll(){
        return tagNameService.findAll();
    }

    @PostMapping
    public ResponseEntity<TagName> addTagName(@RequestBody String tagName){
        tagNameService.save(tagName);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTagName(@PathVariable Long id){
        tagNameService.deleteTagName(id);
        return ResponseEntity.ok().body("Đã xóa");
    }
    @PutMapping("/id")
    public ResponseEntity<String> updateTagName(@PathVariable Long id){
        tagNameService.updateTagName(id);
        return ResponseEntity.ok().body("Đã cập nhật");
    }
}
