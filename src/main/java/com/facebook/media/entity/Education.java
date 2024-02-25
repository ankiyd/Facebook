package com.facebook.media.entity;

import com.facebook.media.dto.EducationDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Education {
    private String school;
    private String degree;
    private String description;
    private Date startDate;
    private Date endDate;

    public static Education convertEducationDtotoEducation(EducationDto educationDto){
        Education education = new Education();
        education.setSchool(educationDto.getSchool());
        education.setDegree(educationDto.getDegree());
        education.setDescription(educationDto.getDescription());
        return education;
    }

    public static List<Education> convertEducationDtostoEducation(List<EducationDto> educationDtos){
        List<Education> educationList = new ArrayList<>();

        for(EducationDto educationDto : educationDtos){
            educationList.add(convertEducationDtotoEducation(educationDto));
        }

        return educationList;
    }
}
