package com.example.demostudmgt.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {

    private Long id;
    @NotEmpty(message = "First Name can't be empty")
    private String firstname;
    @NotEmpty(message = "Last Name can't be empty")
    private String lastname;
    @NotEmpty(message = "Email can't be empty")
    @Email
    private String email;

}
