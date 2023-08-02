package com.example.ManagementBoard.Services;

import com.example.ManagementBoard.Model.Board;
import com.example.ManagementBoard.Repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public List<Board> getAllBoards(){
        return boardRepository.findAll();
    }

    public Board getBoardById(Long boardId){
        Board foundBoard = null;
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if (optionalBoard.isPresent()){
            foundBoard = optionalBoard.get();
        }
        return foundBoard;
    }


    public Board createBoard(@RequestBody Board newBoard){
        return boardRepository.save(newBoard);
    }

    public Board deleteBoard(@PathVariable(name = "id") Long boardId){
        Board existedBoard = getBoardById(boardId);
       if (existedBoard !=null){
           boardRepository.delete(existedBoard);
       }
        return existedBoard;
    }

}
