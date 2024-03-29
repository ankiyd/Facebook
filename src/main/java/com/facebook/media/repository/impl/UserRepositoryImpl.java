package com.facebook.media.repository.impl;

import com.facebook.media.entity.User;
import com.facebook.media.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public User findByUserId(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        return Optional.ofNullable(mongoTemplate.findOne(query, User.class));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return Optional.ofNullable(mongoTemplate.findOne(query, User.class));
    }

    @Override
    public Optional<User> findByUsernameOrEmail(String username, String email) {
        Criteria c1 = Criteria.where("email").is(email);
        Criteria c2 = Criteria.where("username").is(username);
        Query query = new Query(new Criteria().orOperator(c1,c2));
        return Optional.ofNullable(mongoTemplate.findOne(query, User.class));
    }
}
