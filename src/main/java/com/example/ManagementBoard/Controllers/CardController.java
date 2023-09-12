package com.example.ManagementBoard.Controllers;

import com.example.ManagementBoard.Model.Card;
import com.example.ManagementBoard.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("api/board/{boardId}/cards")
@RestController
@CrossOrigin("*")
public class CardController {
    @Autowired
    CardService cardService;

    @GetMapping
    public List<Card> getAllCards(@PathVariable("boardId") Long boardId) {
        List<Card> cards = cardService.getAllCardsByBoardId(boardId);
        return cards;
    }

    @GetMapping(path = "/{cardId}")
    public Card getCardById(@PathVariable("boardId") Long boardId, @PathVariable("cardId") Long cardId) {
        Card card = cardService.getCardById(cardId, boardId);
        return card;
    }

    @PostMapping
    public String createCard(@PathVariable("boardId") Long boardId, @RequestBody Card newCard) {
        Card card = new Card();
        card.setTitle(newCard.getTitle());
        card.setDescription(newCard.getDescription());
        card.setSection(newCard.getSection());

        card = cardService.createCard(boardId, newCard);

        return "Card has been Added";
    }

    @DeleteMapping("/{cardId}")
    public String deleteCard(@PathVariable("boardId") Long boardId, @PathVariable("cardId") Long cardId) {
        cardService.deleteCard(boardId, cardId);
        return "Card with ID= " + cardId + " in board " + boardId;
    }

    @PutMapping("/{cardId}")
    public Card updateCard(@PathVariable("boardId") Long boardId, @PathVariable("cardId") Long cardId, @RequestBody Card card) {
        Card updatedCard = cardService.updateCard(boardId, cardId, card);
        return card;
    }

}
