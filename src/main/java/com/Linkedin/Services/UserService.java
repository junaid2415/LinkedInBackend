package com.Linkedin.Services;

import com.Linkedin.Entities.User;
import com.Linkedin.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.Console;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getUsers(){ return userRepo.findAll(); }

    public Optional<User> postUser(User user){
        userRepo.save(user);
        System.out.println(userRepo.findByUserName(user.getUserName()));
        return userRepo.findByUserName(user.getUserName());

    }

    public Optional<User> getUserByName(String username){
        return userRepo.findByUserName(username);
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
