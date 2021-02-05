package com.Linkedin.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class WorkExperience {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

//    Company Name
    private String company;
//    Job Role
    private String jobTitle;

    @ManyToOne()
//    @JoinColumn(name = "uid")
    private User user;
}
