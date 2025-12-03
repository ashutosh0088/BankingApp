package com.example.bank.domain;

import jakarta.persistence.*;
import org.apache.logging.log4j.util.Lazy;
import tools.jackson.databind.ext.jdk8.OptionalDoubleDeserializer;

import java.time.OffsetDateTime;

public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    public Long id ;

    @Column(name = "amount_paisa" , nullable = false)
    public Long  AmountPaisa ;

    @ManyToOne(optional = false , fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id" , nullable = false )
    public Account account  ;

    @Column(name = "type" , nullable = False)
    private String type ;

    @Column(name = "reference")
    private String reference ; // Optional Idempotency key

    @Column(name = "created at" , nullable = false)
    public OffsetDateTime createdAt = OffsetDateTime.now() ;

}
