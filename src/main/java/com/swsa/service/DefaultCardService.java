package com.swsa.service;
import com.swsa.domain.Card;
import com.swsa.model.CardModel;
import com.swsa.repository.CardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("cardService")
public class DefaultCardService implements CardService{

    @Autowired
    private CardRepository cardRepository;

    @Override
    public CardModel saveCard(CardModel cardModel) {
        Card cardModel1 = populateCardEntity(cardModel);
        return populateCardModel(cardRepository.save(cardModel1));
    }

    @Override
    public boolean deleteCard(Long cardId) {
        cardRepository.deleteById(cardId);
        return true;
    }

    /**
     * Method to return list of all the available customers in the system.This is a simple
     * implementation but you might want to use pagination in the real world example.
     *
     * @return list of card
     */
    @Override
    public List<CardModel> getAllCards() {
       List<CardModel> cards = new ArrayList<>();
        List<Card> cardList = cardRepository.findAll();
        cardList.forEach(card -> {
            cards.add(populateCardModel(card));
        });
        return cards;
    }

    /**
     * Get customer by ID.The service will send the customer data else will throw the exception.
     * @param cardId
     * @return CardModel
     */
    @Override
    public CardModel getCardById(Long cardId) {
        return populateCardModel(cardRepository.findById(cardId).orElseThrow(() -> new EntityNotFoundException("Card not found")));
    }

    /**
     * Internal method to convert Customer JPA entity to the DTO object
     * for frontend data
     * @param card
     * @return CardModel
     */
    private CardModel populateCardModel(final Card card){
        CardModel cardModel = new CardModel();
        cardModel.setId(card.getId());
        cardModel.setCardId(card.getCardId());
        cardModel.setCardNo(card.getCardNo());
        cardModel.setAccountNo(card.getAccountNo());
        cardModel.setAccountHolderName(card.getAccountHolderName());
        cardModel.setCvv(card.getCvv());
        cardModel.setCardType(card.getCardType());
        return  cardModel;
    }

    /**
     * Method to map the frontend customer object to the JPA customer entity.
     * @param cardModel
     * @return Customer
     */
    private Card populateCardEntity(CardModel cardModel){
        Card card = new Card();
        cardModel.setId(card.getId());
        cardModel.setCardId(card.getCardId());
        cardModel.setCardNo(card.getCardNo());
        cardModel.setAccountNo(card.getAccountNo());
        cardModel.setAccountHolderName(card.getAccountHolderName());
        cardModel.setCvv(card.getCvv());
        cardModel.setCardType(card.getCardType());
        return  card;
    }
}
