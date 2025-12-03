package com.example.bank.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne(optional = false , fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id " , nullable = false)
    private User user ;

    @Column(name= "account_number" , unique = true , nullable = false)
    private String accountNumber ;

    @Column(name = "balance_paisas" ,  nullable = false)
    private Long balancePaisas  = 0L;

    @Column( name = "created_at" , nullable = false )
    private OffsetDateTime createdAt = OffsetDateTime.now();
}
