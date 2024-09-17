package com.swsa.service;
import com.swsa.model.CardModel;
import java.util.List;

public interface CardService {

   CardModel saveCard(CardModel cardModel);

    boolean deleteCard(final Long cardId);
    List<CardModel> getAllCards();
    CardModel getCardById(final Long customerId);

}

