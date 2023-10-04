package com.EcommerceProject.EcommerceProject.Service.user;

import com.EcommerceProject.EcommerceProject.Model.User;
import com.EcommerceProject.EcommerceProject.dto.UserDto.UserSignUpRequest;

public interface UserService {

    User addNewUser(UserSignUpRequest user);
    User getUserById(Integer id);
    User getUserByEmail(String email);

}
