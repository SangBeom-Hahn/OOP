package com.example.demo.post.infrastructure;

import com.example.demo.post.service.port.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostJpaRepository postJpaRepository;

    @Override
    public Optional<com.example.demo.post.domain.Post> findById(long id) {
        return postJpaRepository.findById(id).map(Post::toModel);
    }

    @Override
    public com.example.demo.post.domain.Post save(com.example.demo.post.domain.Post post) {
        return postJpaRepository.save(Post.from(post)).toModel();
    }
}
