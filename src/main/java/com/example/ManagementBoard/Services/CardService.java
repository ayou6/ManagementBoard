package com.example.ManagementBoard.Services;

import com.example.ManagementBoard.Model.Board;
import com.example.ManagementBoard.Model.Card;
import com.example.ManagementBoard.Repositories.BoardRepository;
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

    @Autowired
    BoardService boardService;

    public List<Card> getAllCardsByBoardId(Long boardId){
        return cardRepository.findByBoardId(boardId);
    }

    public Card getCardById(Long cardId, Long boardId){
        return cardRepository.findByIdAndBoardId(cardId, boardId);
    }
    public Card createCard(Long boardID, Card newCard){
        Board board = boardService.getBoardById(boardID);
        newCard.setBoard(board);
        return cardRepository.save(newCard);
    }


    public String deleteCard(Long boardId, Long cardId){
        Card card = cardRepository.findByIdAndBoardId(cardId, boardId);
        cardRepository.delete(card);
        return "Deleted";
    }

    public Card updateCard(Long boardId, Long cardId, Card updatedCard) {

        Card card = cardRepository.findByIdAndBoardId(cardId, boardId);

        card.setTitle(updatedCard.getTitle());
        card.setDescription(updatedCard.getDescription());
        card.setSection(updatedCard.getSection());



        return cardRepository.save(card);
    }
}
