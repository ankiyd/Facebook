package com.facebook.media.entity;

import com.facebook.media.request.CreateProfileRequest;
import com.facebook.media.types.ProfilePrivacy;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Data
public class Profile {
    private String profileId;
    private String profilePhoto;
    private String coverPhoto;
    private String gender;
    private List<String> friends;
    private List<Work> workExperience;
    private List<Education> educationInfo;
    private List<Place> places;
    private ProfilePrivacy profilePrivacy;

    public static Profile createProfileFromCreateProfileRequest(CreateProfileRequest createProfileRequest) {
        Profile profile = new Profile();
        profile.setProfileId(UUID.randomUUID().toString());
        profile.setGender(createProfileRequest.getGender());
        profile.setWorkExperience(Work.convertWorkDtosToWork(createProfileRequest.getWorkDtoList()));
        profile.setEducationInfo(Education.convertEducationDtostoEducation(createProfileRequest.getEducationDtoList()));
        profile.setPlaces(Place.convertPlaceDtosToPlaces(createProfileRequest.getPlaceDtoList()));
//      profile.setProfilePrivacy();

        return profile;
    }

}
