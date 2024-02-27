package com.facebook.media.entity;

import com.facebook.media.request.SignUpRequest;
import com.facebook.media.types.AccountStatusType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Data
public class Account {
    @Id
    private String id;
    private String accountId;
    private String password;
    private String username;
    private String email;
    private AccountStatusType accountStatusType;

    public static Account createAccountFromSignUpRequest(SignUpRequest signUpRequest, PasswordEncoder passwordEncoder){
        Account account = new Account();

        account.setUsername(signUpRequest.getUsername());
        account.setEmail(signUpRequest.getEmail());
        account.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        account.setAccountId(UUID.randomUUID().toString());
        account.setAccountStatusType(AccountStatusType.ACTIVE);
        return account;
    }
}


