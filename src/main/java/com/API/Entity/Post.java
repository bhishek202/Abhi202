package com.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = false, length = 5000)
    private String description;
    //
      //One To many relationsgip with Comment entity
    @OneToMany(mappedBy="post",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Comment> comments;

}