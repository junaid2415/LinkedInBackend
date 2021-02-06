package com.Linkedin.Controllers;

import com.Linkedin.Entities.WorkExperience;
import com.Linkedin.Services.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ExperienceController {
    @Autowired
    private WorkExperienceService  workExperienceService;

    @GetMapping("/experiences")
    public List<WorkExperience> getExp() { return  workExperienceService.getExp(); }

    @PostMapping("/user/experience/{id}")
    public void postExp(@RequestBody WorkExperience workExperience, @PathVariable long id){ workExperienceService.postExp(workExperience, id); }

    @PutMapping("/user/{uid}/education/{id}")
    public void updateExp(@RequestBody WorkExperience workExperience,@PathVariable long id, @PathVariable long uid){ workExperienceService.updateExp(workExperience, id, uid);}

    @DeleteMapping("/experience/{id}")
    public void delExp(@PathVariable Long id){ workExperienceService.delExp(id);}
}
