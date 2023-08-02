package com.example.ManagementBoard.Model;

import com.example.ManagementBoard.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Card extends BaseEntity {
    @Id
    public Long cardId;
    public String title;
    public String description;
    public String section;
    @ManyToOne
    @JoinColumn(name = "boardId")
    public Board board;



}
