package com.example.ManagementBoard.Model;

import com.example.ManagementBoard.BaseEntity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Data
public class Card extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public String description;
    public int section;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "boardId")
    public Board board;

    public String getSectionName() {
        return board.getSectionNo(this.section);
    }



}
