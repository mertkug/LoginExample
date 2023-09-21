package com.rateandreview.repository;

import com.rateandreview.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Long>{
    public Set<Post> findPostsByOwnerId(Integer id);
}
