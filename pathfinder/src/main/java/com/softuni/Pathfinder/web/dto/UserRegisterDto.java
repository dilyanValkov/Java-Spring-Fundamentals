package com.softuni.Pathfinder.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {
    @NotNull
    @NotEmpty
    private String userName;

    @NotEmpty
    @Size(min = 5)
    private String fullName;

    @Email
    private String email;

    @Min(0)
    @Max(100)
    private Integer age;


    private String password;

    private String confirmPassword;

    public UserRegisterDto(){
    }

}
