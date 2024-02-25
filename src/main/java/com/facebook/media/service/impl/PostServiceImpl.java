package com.facebook.media.service.impl;

import com.facebook.media.entity.Comment;
import com.facebook.media.entity.Post;
import com.facebook.media.repository.CommentRepository;
import com.facebook.media.repository.PostRepository;
import com.facebook.media.request.CreateCommentRequest;
import com.facebook.media.request.CreatePostRequest;
import com.facebook.media.response.PostResponse;
import com.facebook.media.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository){
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }
    public PostResponse createPost(CreatePostRequest createPostRequest) {
        Post post = Post.createPostFromCreatePostRequest(createPostRequest);
        postRepository.save(post);
        return PostResponse.createPostResponseFromPost(post);
    }

    @Override
    public Comment commentOnPost(CreateCommentRequest createCommentRequest) {
        Comment comment = Comment.createCommentFromCreateCommentRequest(createCommentRequest);
        commentRepository.save(comment);
        Post post = postRepository.getPostById(createCommentRequest.getPostId());
        List<String> listOfCommentId = post.getListOfCommentId();
        listOfCommentId.add(comment.getCommentID());
        post.setListOfCommentId(listOfCommentId);
        postRepository.save(post);
        return comment;
    }

//    @Override
//    public Post getPostByPostId(String postId, String userId){
//        Post post = postRepository.getPostById(postId);
//        if(post.getPostPrivacy() == PostPrivacy.PUBLIC){
//            return post;
//        }
//
//    }

    @Override
    public void likeOnPost(String postId) {
        Post post = postRepository.getPostById(postId);
        int count = post.getLikesCount() + 1;
        post.setLikesCount(count);
        postRepository.save(post);

    }

    @Override
    public String delete(String postId) {
        Post post = postRepository.getPostById(postId);
        return postRepository.deletePostById(postId);
    }

    @Override
    public void update(String postId) {
        return;
    }

}
