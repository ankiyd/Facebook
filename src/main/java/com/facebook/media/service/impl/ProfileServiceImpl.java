package com.facebook.media.service.impl;

import com.facebook.media.entity.Profile;
import com.facebook.media.entity.User;
import com.facebook.media.repository.UserRepository;
import com.facebook.media.request.CreateProfileRequest;
import com.facebook.media.request.UploadPhotoRequest;
import com.facebook.media.service.AWS.AmazonClient;
import com.facebook.media.service.ProfileService;
import com.facebook.media.types.PhotoType;
import com.facebook.media.types.ProfilePrivacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private AmazonClient amazonClient;
    @Override
    public String saveProfile(CreateProfileRequest createProfileRequest) {
        Profile profile = Profile.createProfileFromCreateProfileRequest(createProfileRequest);
        User user = userRepository.findByUserId(createProfileRequest.getUserId());
        user.setProfile(profile);
        userRepository.saveUser(user);
        return "Profile Created!";
    }

    public void savePhoto(UploadPhotoRequest uploadPhotoRequest){
        String uploadUrl = this.amazonClient.uploadFile(uploadPhotoRequest.getImage());
        User user = userRepository.findByUserId(uploadPhotoRequest.getUserId());
        Profile profile = user.getProfile();
        if (PhotoType.PROFILE_PHOTO.equals(uploadPhotoRequest.getPhotoType())) {
            profile.setProfilePhoto(uploadUrl);
        } else if ((PhotoType.COVER_PHOTO.equals(uploadPhotoRequest.getPhotoType()))) {
            profile.setCoverPhoto(uploadUrl);
        } else {
            throw new RuntimeException("Invalid Photo Type");
        }
        user.setProfile(profile);
        userRepository.saveUser(user);
    }

    public Profile findProfileByUserId(String userId, String userIdOfPersonSearching){
        Profile profile = userRepository.findByUserId(userId).getProfile();
        if(profile.getProfilePrivacy() == ProfilePrivacy.OPEN)
            return profile;
        else {
            List<String> friendList = profile.getFriends();
            if(friendList.contains(userIdOfPersonSearching))
                return profile;
            else
                throw new RuntimeException("User not in your friend List");
        }

    }


}
