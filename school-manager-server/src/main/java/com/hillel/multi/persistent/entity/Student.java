package com.hillel.multi.persistent.entity;

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
public class Student {

    @NotNull
    @Size(min = 1, max = 61)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 43)
    private String lastName;

    @NotNull
    @Min(value = 5)
    @Max(value = 16)
    private int age;

    @NotNull
    private Gender gender;

    public enum Gender {
        MALE, FEMALE
    }
}
