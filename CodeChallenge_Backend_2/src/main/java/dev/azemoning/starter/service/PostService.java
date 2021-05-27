package dev.azemoning.starter.service;

import dev.azemoning.starter.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    List<Post> getAllPostByUserId(Long userId);
    Post getPostById(Long id);
    Post addPost(Long userId, Post post);
    Post updatePost(Long userId, Long postId, Post post);
    Post deletePost(Long id);
}
