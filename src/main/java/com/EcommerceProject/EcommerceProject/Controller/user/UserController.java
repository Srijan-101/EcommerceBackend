package com.EcommerceProject.EcommerceProject.Controller.user;


import com.EcommerceProject.EcommerceProject.Service.user.UserService;
import com.EcommerceProject.EcommerceProject.dto.ApiResponse;
import com.EcommerceProject.EcommerceProject.dto.UserDto.UserSignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<ApiResponse> saveUser(@RequestBody UserSignUpRequest user){

        return ResponseEntity.ok(
                new ApiResponse(true,
                        "User Registered sucessfully!",
                        userService.addNewUser(user)));
    }


}
