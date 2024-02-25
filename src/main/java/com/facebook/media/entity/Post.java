package com.facebook.media.entity;

import com.facebook.media.request.CreatePostRequest;
import com.facebook.media.types.PostPrivacy;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@Data
@Document
public class Post {
    @Id
    private String postID;
    private String content;
//    private MultipartFile image;
    private int likesCount;
    private int sharesCount;
    private String postOwner;
    private String location;
    private List<String> tag;
    private List<String> listOfCommentId;
    private PostPrivacy postPrivacy;

    public static Post createPostFromCreatePostRequest(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setContent(createPostRequest.getContent());
//        post.setImage(createPostRequest.getImage());
        post.setTag(createPostRequest.getTag());
        post.setPostOwner(createPostRequest.getUserId());
        post.setLocation(createPostRequest.getLocation());
        post.setListOfCommentId(new ArrayList<>());
        post.setLikesCount(0);
        post.setSharesCount(0);
        post.setPostPrivacy(createPostRequest.getPostPrivacy());
        return post;
    }
}
