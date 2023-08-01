package com.example.ManagementBoard.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Map;
@Entity
@Data
public class Board {
    @Id
    public Long boardId;
    public String title;
    public Map<String, Integer> columns;


}
