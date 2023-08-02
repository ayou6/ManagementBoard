package com.example.ManagementBoard.Model;

import com.example.ManagementBoard.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.*;
@Entity
@Data
public class Board extends BaseEntity {
    @Id
    public Long boardId;
    public String title;
    public Map<String, Long> columns;
    @OneToMany(mappedBy = "board")
    public Set<Card> cards;


}
