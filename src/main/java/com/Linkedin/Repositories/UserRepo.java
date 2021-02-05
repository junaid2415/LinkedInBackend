package com.Linkedin.Repositories;

import com.Linkedin.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
