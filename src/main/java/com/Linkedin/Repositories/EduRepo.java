package com.Linkedin.Repositories;

import com.Linkedin.Entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EduRepo extends JpaRepository<Education,Long> {
}
