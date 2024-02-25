package com.facebook.media.service;

import com.facebook.media.entity.Comment;
import com.facebook.media.entity.Post;
import com.facebook.media.request.CreateCommentRequest;
import com.facebook.media.request.CreatePostRequest;
import com.facebook.media.response.PostResponse;

public interface PostService {
    PostResponse createPost(CreatePostRequest createPostRequest);
    Comment commentOnPost(CreateCommentRequest createCommentRequest);
//    Post getPostByPostId(String postId, String userId);
    void likeOnPost(String postId);
    String delete(String postId);
    void update(String postId);

}
