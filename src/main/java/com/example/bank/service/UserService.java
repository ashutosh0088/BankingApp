package com.example.bank.service;

import com.example.bank.domain.User;
import com.example.bank.dto.UserCreateRequest;
import com.example.bank.dto.UserResponse;
import com.example.bank.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class UserService {

    private final UserRepository userRepository  ;
    public userService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public UserResponse createUser(UserCreateRequest request ){
    userRepository.findByEmail(request.getEmail())
            .ifPresent(u-> {throw new IllegalArgumentException("User Already exists in database"); });
    User user = new User() ;
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    User saved = userRepository.save(user);

    return new UserResponse(saved.getId(), saved.getName(), saved.getEmail()) ;
    }
}
// @Service marks this as business layer.
// @Transactional ensures that all DB operations inside either:
//        all commit, or
//        all roll back if an exception is thrown.
//        We enforce the rule “email must be unique” in code as well as DB.

