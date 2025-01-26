package com.cone.trading.controller;


import com.cone.trading.domain.VerificationType;
import com.cone.trading.model.User;
import com.cone.trading.service.EmailService;
import com.cone.trading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;
    private String jwt;

    @GetMapping("/api/users/profile")
    public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String jwt ) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);

        return new ResponseEntity<User>(user , HttpStatus.OK);
    }

    @PostMapping("api/users/verification/{verificationType}/send-otp")
    public ResponseEntity<User> sendVerificationOtp (
            @RequestHeader("Authorization") String jwt ,
            @PathVariable VerificationType verificationType) throws Exception
    {

        User user = userService.findUserProfileByJwt(jwt);



        return new ResponseEntity<User>(user , HttpStatus.OK);
    }

    @PatchMapping("api/users/enable-two-factor/verify-otp/{otp}")
    public ResponseEntity<User> enableTwoFactorAuthentication (@RequestHeader("Authorization") String jwt ) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);




        return new ResponseEntity<User>(user , HttpStatus.OK);
    }

}
