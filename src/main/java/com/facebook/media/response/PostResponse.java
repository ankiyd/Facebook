package com.facebook.media.response;

import com.facebook.media.entity.Post;
import com.facebook.media.entity.User;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PostResponse {
    private String postID;
    private String content;
    private MultipartFile image;
    private int likesCount;
    private int sharesCount;
    private String postOwner;

    public static PostResponse createPostResponseFromPost(Post post) {
        PostResponse postResponse = new PostResponse();

        postResponse.setPostID(post.getPostID());
        postResponse.setContent(post.getContent());
//        postResponse.setImage(post.getImage());
        postResponse.setPostOwner(post.getPostOwner());
        postResponse.setSharesCount(post.getSharesCount());
        postResponse.setLikesCount(post.getLikesCount());

        return postResponse;
    }
}
