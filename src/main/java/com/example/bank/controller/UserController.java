package com.example.bank.controller;

import com.example.bank.domain.User;
import com.example.bank.dto.UserCreateRequest;
import com.example.bank.dto.UserResponse;
import com.example.bank.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService ;
    public UserController(UserService userService){
        this.userService = userService ;
    }
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserCreateRequest request ){
        UserResponse response = userService.createUser(request)  ;
        return ResponseEntity.ok(response);
    }
}
//    Key points:
//
//@RestController + @RequestMapping("/users") = all endpoints here start with /users.
//
//@PostMapping = handle POST /users.
//
//@Valid triggers validation on UserCreateRequest using its annotations.
//
//@RequestBody tells Spring to parse JSON into the DTO.
