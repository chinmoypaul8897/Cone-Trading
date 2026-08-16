package com.cone.trading.service;

import com.cone.trading.model.User;
import com.cone.trading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomeUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null ) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> authorityList = new ArrayList<>();

        // carry the user's role through so /api/admin/** can be gated on it
        if (user.getRole() != null) {
            authorityList.add(new SimpleGrantedAuthority(user.getRole().toString()));
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),authorityList);
    }
}
