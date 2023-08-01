package com.example.ManagementBoard.Services;

import com.example.ManagementBoard.Repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;



}
