package com.facebook.media.request;

import com.facebook.media.types.PostPrivacy;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class CreatePostRequest {

    private String userId;
    private String content;
    private String location;
    private byte[] image;
    private List<String> tag;
    private PostPrivacy postPrivacy;
}
