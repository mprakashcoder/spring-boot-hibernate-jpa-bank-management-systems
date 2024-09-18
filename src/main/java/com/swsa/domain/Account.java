package com.swsa.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
   @Getter
   @Setter
    @Entity(name = "Account")
    @ToString
    @NoArgsConstructor
    @EntityListeners(AuditingEntityListener.class)
    public class Account
   {
           @Id
           @ToString.Exclude
           @GeneratedValue(strategy = GenerationType.IDENTITY)
           private Long id;

           @Column(name = "accountNumber")
           private String accountNumber;

           @Column(name = "accountHolderName")
           private String accountHolderName;

           @Column(name = "balance")
           private double balance;

           @ToString.Exclude
           private String customerId;

           @ToString.Exclude
           @CreatedDate
           @Column(updatable = false, nullable = false)
           private LocalDateTime createdTime;

           @Column(nullable = false)
           @CreatedDate
           @LastModifiedDate
           private LocalDateTime updatedTime;

        public Account(String accountNumber, String accountHolderName, double balance, String customerId){
           this.accountNumber = accountNumber;
           this.accountHolderName = accountHolderName;
           this.balance = balance;
           this.customerId = customerId;
       }
   }




