package com.swsa.model;
import lombok.Data;

@Data
    public class Accountmodel
{

    private Long id;
    private Long accountNumber;
    private String accountHolderName;
    private double balance;
    private Long customerId;
    }
