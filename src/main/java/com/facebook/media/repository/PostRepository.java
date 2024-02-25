package com.facebook.media.repository;

import com.facebook.media.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository {

    void save(Post post);
    Post getPostById(String postId);
    String deletePostById(String postId);
}
