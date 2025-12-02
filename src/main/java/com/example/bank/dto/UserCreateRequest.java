package com.example.bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {

    @NotBlank
    private String name ;

    @Email
    @NotBlank
    private String email ;

}
//    These classes are used only for API payloads, not DB mapping.