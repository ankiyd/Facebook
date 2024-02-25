package com.facebook.media.dto;

import com.facebook.media.types.PostPrivacy;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PostDto {
    private int postID;
    private String content;
    private MultipartFile images;
    private int likesCount;
    private int sharesCount;
    private UserDto postOwner;
    private PostPrivacy postPrivacy;
}
