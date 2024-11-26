package com.API.Controller;


import com.API.Entity.Post;
import com.API.Repositroy.CommentRepository;
import com.API.Repositroy.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {


    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public PostController(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }
    @PostMapping
    public String createPost(
            @RequestBody Post post
    ){
        postRepository.save(post);
        return "saved";
    }
    @DeleteMapping
    public void deletePost(){
        postRepository.deleteById(1L);
    }
}
