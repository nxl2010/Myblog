package com.example.myblog.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description") // Change the column name to "description"
    private String description;

    @Lob // Đánh dấu trường là Large Object
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "likes")
    private int likes;

    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "posts_tagname",
            joinColumns = @JoinColumn(name = "posts_id"),
            inverseJoinColumns = @JoinColumn(name = "tagname_id"))
    private Set<TagName> tagNames = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "catrgory_id")
    private Category category;
}
