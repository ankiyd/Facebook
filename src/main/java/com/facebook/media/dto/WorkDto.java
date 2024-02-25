package com.facebook.media.dto;

import com.facebook.media.entity.Work;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class WorkDto {
    private String title;
    private String company;
    private String location;
    private String description;
    private Date startDate;
    private Date endDate;

}
