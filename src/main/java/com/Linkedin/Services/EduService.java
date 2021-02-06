package com.Linkedin.Services;

import com.Linkedin.Entities.Education;
import com.Linkedin.Repositories.EduRepo;
import com.Linkedin.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class EduService {
    @Autowired
    private EduRepo eduRepo;

    @Autowired
    private UserRepo userRepo;


    public List<Education> getEducation(){ return eduRepo.findAll(); }


    public void postEdu(  Education education,   long id){
        education.setUser(userRepo.findById(id).get());
        eduRepo.save(education);
    }

    public void updateEdu(  Education education, long id,   long uid){
        education.setId(id);
        education.setUser(userRepo.findById(uid).get());
        eduRepo.save(education);
    }

    public void delEdu(  Long id){
        eduRepo.delete(eduRepo.findById(id).get());

    }
}
