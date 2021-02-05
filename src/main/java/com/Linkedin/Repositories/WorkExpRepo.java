package com.Linkedin.Repositories;

import com.Linkedin.Entities.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExpRepo extends JpaRepository<WorkExperience, Long> {

}
