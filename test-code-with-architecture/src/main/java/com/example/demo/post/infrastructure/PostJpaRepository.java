package com.example.demo.post.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Long> {

}