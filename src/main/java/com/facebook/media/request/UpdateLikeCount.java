package com.facebook.media.request;

import lombok.Data;

@Data
public class UpdateLikeCount {
    String postId;
    boolean toLikeOrUnlike;
}

