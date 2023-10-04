package com.EcommerceProject.EcommerceProject.Repository;

import com.EcommerceProject.EcommerceProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {
     User getUserById(Integer id);
     User getUserByRole(String role);
     User getUserByEmail(String email);

}
