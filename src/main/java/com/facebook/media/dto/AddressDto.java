package com.facebook.media.dto;

import lombok.Data;

@Data
public class AddressDto {
    private int zipCode;
    private String houseNo;
    private String city;
    private String state;
    private String country;
}
