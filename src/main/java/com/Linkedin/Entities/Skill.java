package com.Linkedin.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Skill {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
//  skill name
    private String name;


    @ManyToOne
//    @JoinColumn(name = "uid")
    private User user;
}
