package com.Linkedin.Controllers;

import com.Linkedin.Entities.Education;
import com.Linkedin.Entities.User;
import com.Linkedin.Repositories.EduRepo;
import com.Linkedin.Repositories.UserRepo;
import com.Linkedin.Services.EduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EduController {


    @Autowired
    private EduService eduService;

    @GetMapping("/educations")
    public List<Education> getEducation(){ return eduService.getEducation();}


    @PostMapping("/user/education/{id}")
    public void postEdu(@RequestBody Education education, @PathVariable long id){ eduService.postEdu(education,id);}

    @PutMapping("/user/{uid}/education/{id}")
    public void updateEdu(@RequestBody Education education,@PathVariable long id, @PathVariable long uid){ eduService.updateEdu(education,id,uid);}

    @DeleteMapping("/education/{id}")
    public void delEdu(@PathVariable Long id){ eduService.delEdu(id);}

}
