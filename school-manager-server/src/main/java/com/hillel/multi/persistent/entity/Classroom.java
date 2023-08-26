package com.hillel.multi.persistent.entity;


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
public class Classroom {

    @Min(value = 1)
    @Max(value = 11)
    private int classRange;

    @Min(value = 5)
    @Max(value = 35)
    private int studentsNumber;

    @Pattern(regexp = "^[a-zA-Z]{1}$")
    private String classIndex;
}
