package com.Linkedin.Services;

import com.Linkedin.Entities.WorkExperience;
import com.Linkedin.Repositories.UserRepo;
import com.Linkedin.Repositories.WorkExpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WorkExpRepo workExpRepo;

    public List<WorkExperience> getExp() { return  workExpRepo.findAll();}

    public void postExp(WorkExperience workExperience, long id){
        workExperience.setUser(userRepo.findById(id).get());
        workExpRepo.save(workExperience);
    }

    public void updateExp(WorkExperience workExperience, long id, long uid){
        workExperience.setId(id);
        workExperience.setUser(userRepo.findById(uid).get());
        workExpRepo.save(workExperience);

    }

    public void delExp(long id){
        workExpRepo.delete(workExpRepo.findById(id).get());
    }
}
