package com.facebook.media.entity;

import com.facebook.media.request.CreateCommentRequest;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Comment {
    @Id
    private String commentID;
    private String postId;
    private String comment;
    private int likesCount;
    private String commentCreatedByUserId;
    private String commentCreatedByUserDisplayName;

    public static Comment createCommentFromCreateCommentRequest(CreateCommentRequest createCommentRequest)
    {
        Comment comment = new Comment();
        comment.setPostId(createCommentRequest.getPostId());
        comment.setComment(createCommentRequest.getComment());
        comment.setLikesCount(createCommentRequest.getLikesCount());
        comment.setCommentCreatedByUserId(createCommentRequest.getCommentCreatedByUserId());
        comment.setCommentCreatedByUserDisplayName(createCommentRequest.getCommentCreatedByUserDisplayName());

        return comment;
    }
}
