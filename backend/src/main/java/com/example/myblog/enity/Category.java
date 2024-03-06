package com.example.myblog.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "entry")
    private String entry;
    @Column(name = "color")
    private String color;

    @Column(name = "decribe")
    private String decribe;

    @Column(name = "image")
    private String image;
}
