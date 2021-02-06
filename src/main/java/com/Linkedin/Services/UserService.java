package com.Linkedin.Services;

import com.Linkedin.Entities.User;
import com.Linkedin.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


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
        User temp = userRepo.findById(id).get();
        temp.setUserName(user.getUserName());
        temp.setPassword(user.getPassword());
        temp.setFirstName(user.getFirstName());
        temp.setLastName(user.getLastName());
        temp.setProfilePic(user.getProfilePic());
        userRepo.save(user);
    }

    public void deleteUser(long id){
        userRepo.deleteById(id);
    }
}
