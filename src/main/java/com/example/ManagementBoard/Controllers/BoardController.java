package com.example.ManagementBoard.Controllers;

import com.example.ManagementBoard.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/board")
public class BoardController {

    @Autowired
    BoardService boardService;

}
