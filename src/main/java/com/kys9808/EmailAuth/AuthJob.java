package com.kys9808.EmailAuth;

import java.time.LocalDateTime;

public class AuthJob {
    private String email;
    private String authcode;
    private LocalDateTime expireTime;

    public AuthJob(String email, String authcode, LocalDateTime expireTime) {
        this.email = email;
        this.authcode = authcode;
        this.expireTime = expireTime;
    }

    public String getEmail() {
        return email;
    }

    public String getAuthcode() {
        return authcode;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }
}
