package com.Linkedin.Controllers;

import com.Linkedin.Entities.Education;
import com.Linkedin.Entities.User;
import com.Linkedin.Repositories.EduRepo;
import com.Linkedin.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EduController {

    @Autowired
    private  EduRepo eduRepo;

    @Autowired
    private UserRepo userRepo;


    @GetMapping("/educations")
    public List<Education> getEducation(){
        return eduRepo.findAll();
    }


    @PostMapping("/user/education/{id}")
    public void postEdu(@RequestBody Education education, @PathVariable long id){

        User user = userRepo.findById(id).get();
        List<Education> eduList = user.getEducations();
        education.setUser(user);
        eduRepo.save(education);
        eduList.add(education);
        userRepo.save(user);
    }

    @DeleteMapping("/user/{uid}/education/{id}")
    public User delEdu(@PathVariable Long id,@PathVariable Long uid){
        userRepo.flush();

        User user=userRepo.findById(uid).get();
        List<Education> eduList = user.getEducations();
        Education education= eduRepo.findById(id).get();
        eduList.remove(education);
        user.setEducations(eduList);

//        education.setUser(null);
//        User user1 = new User();
        userRepo.save(user);
        userRepo.flush();
        return  user;

    }

}
