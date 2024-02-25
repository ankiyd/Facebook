package com.facebook.media.request;

import com.facebook.media.types.PhotoType;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class UploadPhotoRequest {
    private String userId;
    private MultipartFile image;
    private PhotoType photoType;
}
