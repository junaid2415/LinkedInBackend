package com.Linkedin.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private  String userName;
    private  String firstName;
    private  String lastName;
    private  String password;
    private String profilePic;


    //            (mappedBy = "user")
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<Education> educations;

    @OneToMany
    private List<Skill> skills;

    @OneToMany
    private List<WorkExperience> workExperiences;


}
