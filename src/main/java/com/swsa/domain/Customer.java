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
@Entity(name = "Customer")
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customerId")
    private int customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "mobileNo")
    private long mobileNo;

    @Column(name = "address")
    private String address;

    @ToString.Exclude
    private String email;

    @ToString.Exclude
    private long aadhaarNo;

    @ToString.Exclude
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdTime;

    @Column(nullable = false)
    @CreatedDate
    @LastModifiedDate
    private LocalDateTime updatedTime;

    public Customer(int customerId,String name,long mobileNo, String address, String email,long aadhaarNo)
    {
        this.customerId=customerId;
        this.mobileNo=mobileNo;
        this.address = address;
        this.email = email;
        this.aadhaarNo=aadhaarNo;
    }
}
