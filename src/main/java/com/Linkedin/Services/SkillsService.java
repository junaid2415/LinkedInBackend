package com.Linkedin.Services;


import com.Linkedin.Entities.Skill;
import com.Linkedin.Repositories.SkillsRepo;
import com.Linkedin.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsService {
    @Autowired
    private SkillsRepo skillsRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Skill> getskills(){ return skillsRepo.findAll(); }

    public void postSkills(  Skill skills,   long id){
        skills.setUser(userRepo.findById(id).get());
        skillsRepo.save(skills);
    }

    public void updateSkills(  Skill skills, long id,   long uid){
        skills.setId(id);
        skills.setUser(userRepo.findById(uid).get());
        skillsRepo.save(skills);
    }

    public void delSkills(  Long id){
        skillsRepo.delete(skillsRepo.findById(id).get());

    }
}
