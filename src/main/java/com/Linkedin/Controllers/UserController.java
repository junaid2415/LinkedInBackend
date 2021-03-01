package com.Linkedin.Controllers;

import com.Linkedin.Entities.User;
import com.Linkedin.Repositories.UserRepo;
import com.Linkedin.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user/")
public class UserController {


    @Autowired
    private UserService userService;

//    shortcut for @RequestMapping(value ="/users", method = RequestMethod.GET)
    @GetMapping("/all")
    public List<User> getUsers(){ return userService.getUsers();}

    @PostMapping("/")
    public Optional<User> postUser(@RequestBody User user)
    {
       return userService.postUser(user);
    }

    @GetMapping("/login/{username}")
    public Optional<User> getUserByName(@PathVariable String username)
    {
        return  userService.getUserByName(username);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user){ userService.updateUser(id,user);}


    @GetMapping("/demo")
    public String getMsg(){
        return "Demo Msg";
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){ userService.deleteUser(id);}
}
