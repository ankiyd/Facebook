package com.facebook.media.request;

import com.facebook.media.dto.EducationDto;
import com.facebook.media.dto.PlaceDto;
import com.facebook.media.dto.WorkDto;
import com.facebook.media.types.ProfilePrivacy;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class CreateProfileRequest {
    private String userId;
    private List<WorkDto> workDtoList;
    private List<EducationDto> educationDtoList;
    private List<PlaceDto> placeDtoList;
    private MultipartFile profilePhoto;
    private MultipartFile coverPhoto;
    private String gender;
    private ProfilePrivacy profilePrivacy;
}
