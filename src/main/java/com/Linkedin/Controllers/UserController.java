package com.Linkedin.Controllers;

import com.Linkedin.Entities.User;
import com.Linkedin.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

//    shortcut for @RequestMapping(value ="/users", method = RequestMethod.GET)
    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping("/user")
    public void postUser(@RequestBody User user){
        userRepo.save(user);
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable long id){
        return userRepo.findById(id).get();
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user){
        User temp = userRepo.findById(id).get();
        temp.setUserName(user.getUserName());
        temp.setPassword(user.getPassword());
        temp.setFirstName(user.getFirstName());
        temp.setLastName(user.getLastName());
        temp.setProfilePic(user.getProfilePic());

        userRepo.save(temp);
    }


    @GetMapping("/demo")
    public String getMsg(){
        return "Demo Msg";
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id){
        userRepo.deleteById(id);
    }
}
