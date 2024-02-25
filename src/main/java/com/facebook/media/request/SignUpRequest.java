package com.facebook.media.request;

import com.facebook.media.dto.AddressDto;
import lombok.Data;

@Data
public class SignUpRequest {
    private String name;
    private String username;
    private String email;
    private String password;
    private String phoneNo;
    private AddressDto addressDto;
}
