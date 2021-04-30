package dev.azemoning.starter.service;

import dev.azemoning.starter.exception.ResourceNotFoundException;
import dev.azemoning.starter.model.Post;
import dev.azemoning.starter.model.User;
import dev.azemoning.starter.repository.PostRepository;
import dev.azemoning.starter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));
    }

    @Override
    public Post addPost(Long userId, Post post) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        post.setUser(user);
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long userId, Long id, Post post) {
        Post findPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        findPost.setContent(post.getContent());
        return postRepository.save(findPost);
    }

    @Override
    public Post deletePost(Long userId, Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        postRepository.delete(post);
        return post;
    }
}
