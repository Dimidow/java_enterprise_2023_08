package com.hillel.multi.persistent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int student_id;

    @NotNull
    @Size(min = 1, max = 61)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 43)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Min(value = 5)
    @Max(value = 16)
    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
}
