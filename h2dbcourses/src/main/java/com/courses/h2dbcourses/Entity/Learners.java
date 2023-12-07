package com.courses.h2dbcourses.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="learners")
public class Learners implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int learnerId;
    private String learnerFirstName;
    private String learnerLastName;
    private String learnerEmail;
    private String learnerPassword;
    private int learnerCourseId;
}
