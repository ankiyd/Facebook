package com.facebook.media.repository.impl;

import com.facebook.media.entity.Post;
import com.facebook.media.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Post post) {
        mongoTemplate.save(post);
    }

    public Post getPostById(String postId){
        return mongoTemplate.findById(postId, Post.class);
    }

    public String deletePostById(String postId){
        Query query = new Query();
        query.addCriteria(Criteria.where("postID").is(postId));
        mongoTemplate.findAndRemove(query, Post.class);
        return "Post Deleted successfully!";
    }
}
