package com.example.service;

import com.example.model.FreeBoard;
import com.example.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jins on 2017-04-25.
 */
@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public Iterable<FreeBoard> findAllInfo(){
        Iterable<FreeBoard> allArticle = boardRepository.findAll();
        return allArticle;
    }
}
