package com.swsa.model;
import lombok.Data;

@Data
public class CustomerModel {

    private Long id;
    private   Long customerId;
    private  String name;
    private   Long mobileNo;
    private  String address;
    private  String emailId;
    private Long aadhaarNo;
}
