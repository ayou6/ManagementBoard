package com.example.ManagementBoard.Services;

import com.example.ManagementBoard.Model.Board;
import com.example.ManagementBoard.Model.Card;
import com.example.ManagementBoard.Repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public List<Card> getAllCards(){
        return cardRepository.findAll();}

    public Card getCardById(Long cardId){
        Card foundCard =null;
        Optional<Card> optionalCard = cardRepository.findById(cardId);
        if (optionalCard.isPresent()){
            foundCard = optionalCard.get();
        }
        return foundCard;}
    public Card createCard(@RequestBody Card newCard){
        return cardRepository.save(newCard);
    }


    public Card deleteCard(@PathVariable(name = "id")Long cardId){
        Card existedCard = getCardById(cardId);
        if (existedCard  !=null){
            cardRepository.delete(existedCard);}
        return existedCard;
    }

    public Card updateCard(Card updatedCard) {
        Long cardId = updatedCard.getCardId();
        Optional<Card> optionalCard = cardRepository.findById(cardId);
        if (optionalCard.isPresent()) {
            Card existingCard = optionalCard.get();
            existingCard.setTitle(updatedCard.getTitle());
            existingCard.setDescription(updatedCard.getDescription());
            existingCard.setSection(updatedCard.getSection());
            return cardRepository.save(existingCard);
        } else {
            return null;
        }
    }
}
