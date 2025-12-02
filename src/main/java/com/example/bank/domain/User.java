package com.example.bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(Name="bank_user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank
    @Column(nullable = false)
    private String name ;

    @Email
    @NotBlank
    @Column(nullable = false)
    private String email ;

    @Column(name = "created_at" , nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now() ;

}
