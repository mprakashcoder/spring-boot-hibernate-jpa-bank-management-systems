package com.swsa.model;
import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardModel
    {
         private Long id;
         private  Long cardId;
         private Long cardNo;
         private  Long accountNo;
         private  String accountHolderName;
         private  int cvv;
         private  String cardType;

    }

