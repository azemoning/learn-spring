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

    @GetMapping("post")
    public ResponseEntity<Object> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("post/{id}")
    public ResponseEntity<Object> getPostById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @PostMapping("user/{userId}/post")
    public ResponseEntity<Object> addPost(@PathVariable Long userId, @RequestBody Post post) {
        return new ResponseEntity<>(postService.addPost(userId, post), HttpStatus.CREATED);
    }

    @PutMapping("user/{userId}/post/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable Long userId,
                                             @PathVariable Long id,
                                             @RequestBody Post post) {
        return new ResponseEntity<>(postService.updatePost(userId, id, post), HttpStatus.OK);
    }

    @DeleteMapping("user/{userId}/post/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable Long userId,
                                             @PathVariable Long id) {
        return new ResponseEntity<>(postService.deletePost(userId, id), HttpStatus.OK);
    }
}
