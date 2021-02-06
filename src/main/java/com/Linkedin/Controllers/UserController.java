package com.Linkedin.Controllers;

import com.Linkedin.Entities.User;
import com.Linkedin.Repositories.UserRepo;
import com.Linkedin.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {


    @Autowired
    private UserService userService;

//    shortcut for @RequestMapping(value ="/users", method = RequestMethod.GET)
    @GetMapping("/users")
    public List<User> getUsers(){ return userService.getUsers();}

    @PostMapping("/user")
    public void postUser(@RequestBody User user){
        userService.postUser(user);
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user){ userService.updateUser(id,user);}


    @GetMapping("/demo")
    public String getMsg(){
        return "Demo Msg";
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id){ userService.deleteUser(id);}
}
