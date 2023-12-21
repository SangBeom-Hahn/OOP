package com.example.demo.post.domain;

import com.example.demo.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.time.Clock;

@Getter
public class Post {
    private Long id;

    private String content;

    private Long createdAt;

    private Long modifiedAt;

    @Builder
    public Post(Long id, String content, Long createdAt, Long modifiedAt, User writer) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.writer = writer;
    }

    private User writer;


    public static Post from(User writer, PostCreate postCreate) {
        return Post.builder()
                .content(postCreate.getContent())
                .writer(writer)
                .createdAt(Clock.systemUTC().millis())
                .build();

    }

    public Post update(PostUpdate postUpdate) {
        return Post.builder()
                .id(id)
                .content(postUpdate.getContent())
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .writer(writer)
                .build();
    }
}
