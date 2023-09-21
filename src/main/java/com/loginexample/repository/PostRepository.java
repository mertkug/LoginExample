package com.loginexample.repository;

import com.loginexample.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Long>{
    public Set<Post> findPostsByOwnerId(Integer id);
}
