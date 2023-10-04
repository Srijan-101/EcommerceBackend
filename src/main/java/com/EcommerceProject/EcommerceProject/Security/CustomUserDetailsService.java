package com.EcommerceProject.EcommerceProject.Security;


import com.EcommerceProject.EcommerceProject.Model.User;
import com.EcommerceProject.EcommerceProject.Repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userrepository;
    CustomUserDetailsService(UserRepository userrepository){
         this.userrepository = userrepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userrepository.getUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }


        String role = user.getRole();
        GrantedAuthority authority = new SimpleGrantedAuthority(role);

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), Collections.singleton(authority));

    }
}
