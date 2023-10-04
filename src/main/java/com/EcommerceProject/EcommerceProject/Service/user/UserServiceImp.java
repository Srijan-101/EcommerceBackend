package com.EcommerceProject.EcommerceProject.Service.user;

import com.EcommerceProject.EcommerceProject.Enums.UserRole;
import com.EcommerceProject.EcommerceProject.Exception.AppException;
import com.EcommerceProject.EcommerceProject.Model.User;
import com.EcommerceProject.EcommerceProject.Repository.UserRepository;
import com.EcommerceProject.EcommerceProject.Security.PasswordEncoderService;
import com.EcommerceProject.EcommerceProject.dto.UserDto.UserSignUpRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImp  implements  UserService{

    private final UserRepository userRepository;
    private final PasswordEncoderService passwordEncoderService;
    @Override
    public User addNewUser(UserSignUpRequest user) {
       if(userRepository.getUserByEmail(user.getEmail()) != null){
           throw new AppException("User already exists for given email", HttpStatus.BAD_REQUEST);
       }
       User newUser = new User();
       newUser.setId(user.getId());
       newUser.setFirstName(user.getFirstName());
       newUser.setLastName(user.getLastName());
       newUser.setEmail(user.getEmail());

       String encryptedPassword = passwordEncoderService
               .getPasswordEncoder()
               .encode(user.getPassword());

       newUser.setPassword(encryptedPassword );

        if(user.getRoleId() == 1){
            newUser.setRole(String.valueOf(UserRole.ADMIN));
        }
        else if(user.getRoleId() == 2){
            newUser.setRole(String.valueOf(UserRole.CUSTOMER));
        }
        else {
            throw new AppException("Invalid Role. Please try again", HttpStatus.BAD_REQUEST);
        }
        userRepository.saveAndFlush(newUser);
        return newUser;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
