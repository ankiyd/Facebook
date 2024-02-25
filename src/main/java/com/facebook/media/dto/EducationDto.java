package com.facebook.media.dto;

import com.facebook.media.entity.Education;
import lombok.Data;

@Data
public class EducationDto {
    private String school;
    private String degree;
    private String description;

    public static EducationDto convertEducationtoEducationDto(Education education){
        EducationDto educationDto = new EducationDto();
        educationDto.setSchool(education.getSchool());
        educationDto.setDegree(education.getDegree());
        educationDto.setDescription(education.getDescription());
        return educationDto;
    }
}
