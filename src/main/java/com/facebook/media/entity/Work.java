package com.facebook.media.entity;

import com.facebook.media.dto.WorkDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class Work {
    private String workId;
    private String title;
    private String company;
    private String location;
    private String description;
    private Date startDate;
    private Date endDate;

    public static Work convertWorkDtoToWork(WorkDto workDto){
        Work work = new Work();

        work.setWorkId(UUID.randomUUID().toString());
        work.setTitle(workDto.getTitle());
        work.setCompany(workDto.getCompany());
        work.setLocation(workDto.getLocation());
        work.setDescription(workDto.getDescription());
        work.setStartDate(workDto.getStartDate());
        work.setEndDate(workDto.getEndDate());

        return work;
    }

    public static List<Work> convertWorkDtosToWork(List<WorkDto> workDto){
        List<Work> listOfWorks = new ArrayList<>();
        for(WorkDto work : workDto)
            listOfWorks.add(convertWorkDtoToWork(work));

        return listOfWorks;
    }


}
