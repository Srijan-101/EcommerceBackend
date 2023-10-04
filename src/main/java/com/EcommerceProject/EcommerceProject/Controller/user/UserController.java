package com.EcommerceProject.EcommerceProject.Controller.user;


import com.EcommerceProject.EcommerceProject.Exception.AppException;
import com.EcommerceProject.EcommerceProject.Service.user.UserService;
import com.EcommerceProject.EcommerceProject.Utility.JWTUtil;
import com.EcommerceProject.EcommerceProject.dto.ApiResponse;
import com.EcommerceProject.EcommerceProject.dto.UserDto.LoginUserDto;
import com.EcommerceProject.EcommerceProject.dto.UserDto.UserSignUpRequest;
import com.EcommerceProject.EcommerceProject.dto.jwtResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, JWTUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/SignUp")
    public ResponseEntity<ApiResponse> saveUser(@RequestBody @Valid UserSignUpRequest user){
        return ResponseEntity.ok(
                new ApiResponse(true,
                        "User Registered sucessfully!",
                        userService.addNewUser(user)));
    }

    @PostMapping("/Login")
    public ResponseEntity<jwtResponseDto> Login(@RequestBody LoginUserDto loginUserDto){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtil.generateToken(authentication);
            return ResponseEntity.ok(new jwtResponseDto(jwt));
        }
        catch (AuthenticationException e){
            throw new AppException("Incorrect email or password", HttpStatus.BAD_REQUEST);
        }
    }

}
