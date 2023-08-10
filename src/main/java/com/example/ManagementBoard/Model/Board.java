package com.example.ManagementBoard.Model;

import com.example.ManagementBoard.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
@Entity
@Data
public class Board{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;

    @OneToMany(mappedBy = "board")
    public List<Card> cards;

    public static String getSectionNo(int sectionSelect) {
        if (sectionSelect == 1) {
            return "To Do";
        } else if (sectionSelect == 2) {
            return "In Progress";
        } else if (sectionSelect == 3) {
            return "Done";
        } else {
            return "Unknown";

        }
    }
}