package com.facebook.media.dto;

import lombok.Data;

import java.util.Date;
@Data
public class MessageDto {
    private UserDto recipient;
    private UserDto sender;
    //private FriendRequestStatus status;
    private Date requestSent;
    private Date requestStatusModified;

}
