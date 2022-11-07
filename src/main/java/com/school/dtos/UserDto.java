package com.school.dtos;

import javax.validation.constraints.NotBlank;

public class UserDto {
    
    @NotBlank
    private String username;
    @NotBlank
    private String cpf;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String orgId;
    
}
