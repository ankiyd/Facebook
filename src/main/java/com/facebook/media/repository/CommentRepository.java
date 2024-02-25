package com.facebook.media.repository;

import com.facebook.media.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository {
    void save(Comment comment);
}
