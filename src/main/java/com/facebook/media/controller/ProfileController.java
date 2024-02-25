package com.facebook.media.controller;

import com.facebook.media.entity.Profile;
import com.facebook.media.request.CreateProfileRequest;
import com.facebook.media.request.UploadPhotoRequest;
import com.facebook.media.service.ProfileService;
import com.facebook.media.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;
    @Autowired
    UserService userService;

    @PostMapping(value = "/photo", consumes =  { MediaType.MULTIPART_FORM_DATA_VALUE } )
    public String uploadFile(@RequestBody UploadPhotoRequest uploadPhotoRequest) {
        profileService.savePhoto(uploadPhotoRequest);
        return "Profile Photo successfully uploaded";
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        //return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
        return null;
    }

    @PostMapping("/createProfile")
    public String createProfile(@RequestBody CreateProfileRequest createProfileRequest){
        return profileService.saveProfile(createProfileRequest);
    }

    @GetMapping("/search/{id}")
    public Profile getProfileByUserId(@RequestParam (value = "id") String userId, String userIdOfPersonSearching){
        return profileService.findProfileByUserId(userId, userIdOfPersonSearching);
    }
}
