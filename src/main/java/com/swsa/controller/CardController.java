package com.swsa.controller;
import com.swsa.model.CardModel;
import com.swsa.service.CardService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(value = "/cardManagement")
public class CardController {

    @Resource(name = "cardService")
    private CardService cardService;

    @GetMapping("/cards")
    public List<CardModel> getCards(){
        return cardService.getAllCards();
    }

    @GetMapping("/card/{id}")
    public CardModel getCard(@PathVariable Long id){
        return cardService.getCardById(id);
    }

    @PostMapping("/card")
    public CardModel saveCard(final @RequestBody CardModel cardModel){
        return cardService.saveCard(cardModel);
    }

    @DeleteMapping("/card/{id}")
    public Boolean deleteCard(@PathVariable Long id){
        return cardService.deleteCard(id);
    }
}
