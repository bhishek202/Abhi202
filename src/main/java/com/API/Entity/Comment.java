package com.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
//Many belongs to the Comment and One belong to the popst
    @ManyToOne
    // Join Colloum used here define is the foren key
    @JoinColumn(name = "post_id")
    private Post post;


    public void setPost(Post post) {
    }
}