package dev.azemoning.starter.controller;

import dev.azemoning.starter.model.Post;
import dev.azemoning.starter.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    @GetMapping("post/all")
    public ResponseEntity<Object> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("post/detail/{userId}")
    public ResponseEntity<Object> getAllPostByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(postService.getAllPostByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("post/add/{userId}")
    public ResponseEntity<Object> addPost(@PathVariable Long userId, @RequestBody Post post) {
        return new ResponseEntity<>(postService.addPost(userId, post), HttpStatus.CREATED);
    }

    @PutMapping("post/update/{userId}/{postId}")
    public ResponseEntity<Object> updatePost(@PathVariable Long userId,
                                             @PathVariable Long postId,
                                             @RequestBody Post post) {
        return new ResponseEntity<>(postService.updatePost(userId, postId, post), HttpStatus.OK);
    }

    @DeleteMapping("post/delete/{postId}")
    public ResponseEntity<Object> deletePost(@PathVariable Long postId) {
        return new ResponseEntity<>(postService.deletePost(postId), HttpStatus.OK);
    }
}
