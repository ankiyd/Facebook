package com.facebook.media.entity;

import com.facebook.media.request.SignUpRequest;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.UUID;

@Data
public class User extends Person {
    @Id
    private String id;
    private String userId;
    private Date dateOfJoining;
//    private List<Pages> pagesAdmin;
//    private List<Groups> groupsAdmin;
    private Profile profile;


    public static User createUserFromSignUpRequest(SignUpRequest signUpRequest,PasswordEncoder passwordEncoder){
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setUserId(UUID.randomUUID().toString());
        user.setAccount(Account.createAccountFromSignUpRequest(signUpRequest, passwordEncoder));
        user.setDateOfJoining(new Date(System.currentTimeMillis()));
        user.setEmail(signUpRequest.getEmail());

        return user;
    }
}