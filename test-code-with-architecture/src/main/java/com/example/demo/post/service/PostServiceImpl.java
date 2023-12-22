package com.example.demo.service;


import com.example.demo.common.domain.exception.ResourceNotFoundException;
import com.example.demo.post.controller.port.PostService;
import com.example.demo.post.domain.Post;
import com.example.demo.post.domain.PostCreate;
import com.example.demo.post.domain.PostUpdate;

import com.example.demo.post.service.port.PostRepository;

import com.example.demo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final com.example.demo.service.UserServiceImpl userServiceImpl;

    public Post getById(long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Posts", id));
    }

    public Post create(PostCreate postCreate) {
        User writer = userServiceImpl.getById(postCreate.getWriterId());
        Post post = Post.from(writer, postCreate);
        return postRepository.save(post);
    }

    public Post update(long id, PostUpdate postUpdate) {
        Post post = getById(id);
        post = post.update(postUpdate);
        return postRepository.save(post);
    }
}