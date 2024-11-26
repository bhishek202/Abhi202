package com.API.Controller;


import com.API.Entity.Comment;
import com.API.Entity.Post;
import com.API.Repositroy.CommentRepository;
import com.API.Repositroy.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @RequestMapping
    public String createComment(@RequestBody Comment comment, @RequestParam long postId){

         Post post=postRepository.findById(postId).get();
         comment.setPost(post);


        commentRepository.save(comment);

        return "Comment create  succesfully";
    }
}
