package com.example.ManagementBoard.Controllers;

import com.example.ManagementBoard.Model.Card;
import com.example.ManagementBoard.Services.CardService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("api/boards/{boardId}/cards")
@RestController
@CrossOrigin("*")
public class CardController {
    @Autowired
    CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping(path = "{id}")
    public Card getCardById(@PathVariable(name = "id") Long cardId) {
        Card cardFound = null;
        if (Strings.isNotBlank(String.valueOf(cardId))) {
            cardFound = cardService.getCardById(cardId);
        }
        return cardFound;
    }

    @PostMapping
    public Card createCard(@RequestBody Card newCard) {
        return cardService.createCard(newCard);
    }

    @PutMapping(path = "{id}")
    public Card deleteBoard(@PathVariable(name = "id") Long cardId) {
        return cardService.deleteCard(cardId);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Card> updateCard(@PathVariable(name = "id") Long cardId,
            @RequestBody Card updatedCard
    ) {
        Card existingCard = cardService.getCardById(cardId);

        if (existingCard == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the card attributes
        existingCard.setTitle(updatedCard.getTitle());
        existingCard.setDescription(updatedCard.getDescription());
        existingCard.setSection(updatedCard.getSection());

        Card updated = cardService.updateCard(existingCard);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
