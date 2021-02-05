package com.Linkedin.Repositories;

import com.Linkedin.Entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepo extends JpaRepository<Skill,Long> {
}
