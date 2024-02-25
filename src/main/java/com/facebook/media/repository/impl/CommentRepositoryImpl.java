package com.facebook.media.repository.impl;

import com.facebook.media.entity.Comment;
import com.facebook.media.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Comment comment){
        mongoTemplate.save(comment);
    }
}
