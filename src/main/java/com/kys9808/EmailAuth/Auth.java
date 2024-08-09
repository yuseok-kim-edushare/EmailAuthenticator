package com.kys9808.EmailAuth;

import java.time.LocalDateTime;
import java.util.Random;

class Authenticating {
    public static String generateAuthCode() {
        // Generate a random 7-digit authentication code
        Random random = new Random();
        int randomNumber;
        randomNumber = 10000000 + random.nextInt(90000000);
        return "S" + String.valueOf(randomNumber);
    }
}

public class Auth {
    public static AuthJob AuthStart(String userEmail, String serviceProviderEmail, String serviceProviderPassword) {
        String authChallenge = Authenticating.generateAuthCode();
        AuthJob AuthJob = new AuthJob(userEmail, authChallenge, LocalDateTime.now().plusMinutes(5));
        authChallenge = "your authentication code is: " + authChallenge;
        EmailSender.sendEmail(userEmail, "Authentication Code", authChallenge, serviceProviderEmail, serviceProviderPassword);
        return AuthJob;
    }
    public static boolean AuthCheck(AuthJob AuthJob, String authCode) {
        return LocalDateTime.now().isBefore(AuthJob.getExpireTime()) && AuthJob.getAuthcode().equals(authCode);
    }
}

