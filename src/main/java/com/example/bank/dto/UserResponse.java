package com.example.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private Long id ;
    private String name ;
    private String email ;
}
// These classes are used only for API payloads, not DB mapping.
