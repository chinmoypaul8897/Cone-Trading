package com.cone.trading.controller;

import com.cone.trading.config.JwtProvider;
import com.cone.trading.model.TwoFactorOTP;
import com.cone.trading.model.User;
import com.cone.trading.repository.UserRepository;
import com.cone.trading.response.AuthResponse;
import com.cone.trading.service.CustomeUserDetailsService;
import com.cone.trading.service.TwoFactorOtpService;
import com.cone.trading.utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomeUserDetailsService customeUserDetailsService ;

    @Autowired
    private TwoFactorOtpService twoFactorOtpService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody User user ) throws Exception
    {

        // email check
        User isEmailExist = userRepository.findByEmail(user.getEmail());

        if (isEmailExist != null )
        {
            throw new Exception("email is already used with another account ");
        }

        // new user create
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setFullName(user.getFullName());

        // save new user data
        User savedUser = userRepository.save(newUser);

        Authentication auth = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()
        );
        SecurityContextHolder.getContext().setAuthentication(auth);

        // create jwt token
        String jwt = JwtProvider.generateToken(auth);

        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setStatus(true);
        res.setMessage("register success");


        return new ResponseEntity<>(res, HttpStatus.CREATED);


    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> login (@RequestBody User user ) throws Exception
    {
        String userName = user.getEmail();
        String password = user.getPassword();

        Authentication auth = authenticate(userName,password);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // create jwt token
        String jwt = JwtProvider.generateToken(auth);

        User authUser = userRepository.findByEmail(userName);

        if (user.getTwoFactorAuth().isEnabled())
        {
            AuthResponse res = new AuthResponse();

            res.setMessage("Two Factor Auth is Enabled");

            res.setTwoFactorAuthEnabled(true);

            String otp = OtpUtils.generateOTP();

            TwoFactorOTP oldTwoFactorOTP = twoFactorOtpService.findByUser(authUser.getId());

            if (oldTwoFactorOTP != null )
            {
                twoFactorOtpService.deleteTwoFactorOtp(oldTwoFactorOTP);


            }

            TwoFactorOTP newTwoFactorOTP = twoFactorOtpService.createTwoFactorOtpService(authUser,otp,jwt);



            res.setSession(new TwoFactorOTP().getId());

            return new ResponseEntity<>(res,HttpStatus.ACCEPTED);

        }

        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setStatus(true);
        res.setMessage("login success");


        return new ResponseEntity<>(res, HttpStatus.CREATED);


    }

    private Authentication authenticate(String userName, String password) {
        UserDetails userDetails = customeUserDetailsService.loadUserByUsername(userName);

        if (userDetails==null)
        {
            throw new BadCredentialsException("invalid username");

        }
        if (!password.equals(userDetails.getPassword()))
        {
            throw new BadCredentialsException("invalid password ");
        }

        return new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
    }


}
