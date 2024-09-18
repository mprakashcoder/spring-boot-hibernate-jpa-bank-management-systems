package com.swsa.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Accountmodel {

        private Long id;
        private  String accountNumber;
        private String accountHolderName;
        private double balance;
        private String customerId;
        // Customer customer;
    }
