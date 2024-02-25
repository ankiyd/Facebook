package com.facebook.media.service;

import com.facebook.media.entity.Profile;
import com.facebook.media.request.CreateProfileRequest;
import com.facebook.media.request.UploadPhotoRequest;

public interface ProfileService {

//    String updateWorkExperience(Work work);
//    String updateEducation(Education education);
//    String updatePlace(Place place);
//    String updateProfilePicture();
//    String updateCoverPicture();
//    String updateGender();

    String saveProfile(CreateProfileRequest createProfileRequest);
    void savePhoto(UploadPhotoRequest uploadPhotoRequest);
    Profile findProfileByUserId(String userId, String userIdOfPersonSearching);
}
