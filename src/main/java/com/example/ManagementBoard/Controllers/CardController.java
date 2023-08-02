package com.example.ManagementBoard.Controllers;

import com.example.ManagementBoard.Model.Card;
import com.example.ManagementBoard.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("api/boards/{boardId}/cards")
@RestController
@CrossOrigin("*")
public class CardController  {
    @Autowired
    CardService cardService;

    @GetMapping
    public List<Card> getAllCards(){return cardService.getAllCards();}





}
