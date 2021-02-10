package com.Linkedin.Services;

import com.Linkedin.Entities.User;
import com.Linkedin.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getUsers(){ return userRepo.findAll(); }

    public void postUser(User user){
        userRepo.save(user);
    }

    public User getUser(long id){
        return userRepo.findById(id).get();
    }

    public void updateUser(long id, User user){
        user.setId(id);
        userRepo.save(user);
    }

    public void deleteUser(long id){
        userRepo.deleteById(id);
    }
}
