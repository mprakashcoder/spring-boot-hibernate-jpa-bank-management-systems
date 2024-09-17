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
@Entity(name = "Card")
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Card {

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cardId")
    private Long cardId;

    @Column(name = "cardNo")
    private Long cardNo;

    @Column(name = "accountNo")
    private Long accountNo;

    @Column(name = "accountHolderName")
    private String accountHolderName;

    @ToString.Exclude
    private int cvv;

    @Column(name = "cardType")
    private String cardType;

    @ToString.Exclude
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdTime;

    @Column(nullable = false)
    @CreatedDate
    @LastModifiedDate
    private LocalDateTime updatedTime;

    public Card( Long cardId, Long cardNo, Long accountNo, String accountHolderName, int cvv, String cardType) {
        this.cardId = cardId;
        this.cardNo = cardNo;
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.cvv = cvv;
        this.cardType = cardType;
    }
}

