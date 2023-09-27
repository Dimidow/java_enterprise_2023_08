package com.hillel.multi.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private int student_id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
}
