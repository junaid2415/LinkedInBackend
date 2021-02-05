package com.Linkedin.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity

@Data
@NoArgsConstructor
public class Education {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

//    school Name
    private String school;
//    Degree
    private String degree;
//    Feild oF Study
    private String fos;

    @ManyToOne
    @JsonIgnore
//    @JoinColumn(name = "uid")

    private User user;
}
