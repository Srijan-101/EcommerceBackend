package com.EcommerceProject.EcommerceProject.Security;

import com.EcommerceProject.EcommerceProject.Config.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService CustomUserDetailsService;
    private final PasswordEncoderService passwordEncoderService;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    SecurityConfiguration(
            CustomUserDetailsService CustomUserDetailsService,
            PasswordEncoderService passwordEncoderService, JwtAuthenticationFilter jwtAuthenticationFilter){
        this.CustomUserDetailsService = CustomUserDetailsService;
        this.passwordEncoderService = passwordEncoderService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors()
                .and()
                .authorizeHttpRequests()
                .antMatchers("/api/user/SignUp").permitAll()
                .antMatchers("/api/user/Login").permitAll()
                .antMatchers("/api/category/getAll").permitAll()
                .antMatchers("/api/category/save").hasAnyAuthority("ADMIN")
                .antMatchers("/api/product/saveProduct").hasAnyAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(CustomUserDetailsService)
                .passwordEncoder(passwordEncoderService.getPasswordEncoder());
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
