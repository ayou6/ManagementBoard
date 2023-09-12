package com.example.ManagementBoard.Controllers;

import com.example.ManagementBoard.Model.Board;
import com.example.ManagementBoard.Services.BoardService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping
    public List<Board> getAllBoards(){return boardService.getAllBoards();}

    @GetMapping(path = "/{id}")
    public Board getBoardById(@PathVariable(name = "id")Long boardId){
        Board boardFound = null;
        if (Strings.isNotBlank(String.valueOf(boardId))){
            boardFound = boardService.getBoardById(boardId);
        }
        return boardFound;
    }

    @PostMapping
    public Board createBoard(@RequestBody Board newBoard){
        return boardService.createBoard(newBoard);
    }

    @PutMapping(path = "/{id}")
    public String updateBoard(@PathVariable(name = "id")Long boardId, @RequestBody Board updatedBoard){
        Board board = boardService.getBoardById(boardId);

        board.setTitle(updatedBoard.getTitle());

        boardService.createBoard(board);
        return "Updated";
    }

    @DeleteMapping(path ="/{id}")
    public void deleteBoard(@PathVariable(name = "id")Long id){boardService.deleteBoard(id);}

}
