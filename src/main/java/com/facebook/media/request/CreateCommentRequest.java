package com.facebook.media.request;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class CreateCommentRequest {
    private String commentCreatedByUserId;
    private String commentCreatedByUserDisplayName;
    private String postId;
    private String comment;
    private int likesCount;

}
