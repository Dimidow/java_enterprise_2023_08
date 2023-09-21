package com.hillel.multi.persistent.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classroom_id;
    @Min(value = 1)
    @Max(value = 11)
    @Column(name = "class_range")
    private int classRange;

    @Min(value = 5)
    @Max(value = 35)
    @Column(name = "students_number")
    private int studentsNumber;

    @Pattern(regexp = "^[a-zA-Z]{1}$")
    @Column(name = "class_index")
    private String classIndex;

    @OneToMany(mappedBy = "classroom")
    private List<Student> students;
}
