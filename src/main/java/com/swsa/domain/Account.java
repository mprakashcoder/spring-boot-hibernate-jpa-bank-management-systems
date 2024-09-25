package com.swsa.domain;
import com.swsa.model.Accountmodel;
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
    @Entity(name = "account")
    @ToString
    @NoArgsConstructor
    @EntityListeners(AuditingEntityListener.class)
    public class Account extends Accountmodel {
           @Id
           @ToString.Exclude
           @GeneratedValue(strategy = GenerationType.IDENTITY)
           private Long id;

           @Column(name = "accountNumber")
           private  Long accountNumber;

           @Column(name = "accountHolderName")
           private  String accountHolderName;

          @Column(name = "balance")
          private  Double balance;

           @ToString.Exclude
           private   Long customerId;

           @ToString.Exclude
           @CreatedDate
           @Column(updatable = false, nullable = false)
           private LocalDateTime createdTime;

           @Column(nullable = false)
           @CreatedDate
           @LastModifiedDate
           private LocalDateTime updatedTime;

        public Account(Long accountNumber, String accountHolderName, double balance, Long customerId){
           this.accountNumber = accountNumber;
           this.accountHolderName = accountHolderName;
           this.balance = balance;
           this.customerId = customerId;
       }
   }




