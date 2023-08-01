package com.example.ManagementBoard.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Card {
    @Id
    public Long cardId;
    public String title;
    public String description;
    public String section;



}
