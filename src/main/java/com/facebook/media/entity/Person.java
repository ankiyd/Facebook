package com.facebook.media.entity;

import lombok.Data;

@Data
public abstract class Person {
    private String name;
    private String email;
    private String phone;
    private Account account;
}
