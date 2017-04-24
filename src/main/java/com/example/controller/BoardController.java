package com.example.controller;

import com.example.model.Member;
import com.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jins on 2017-04-25.
 */
@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/all")
    public ResponseEntity<Member> findAllArticle(){
        Map<String,Object> result = new HashMap<String, Object>();
        System.out.println(boardService.findAllInfo());
        result.put("result", boardService.findAllInfo());

        return new ResponseEntity(result, HttpStatus.OK);
    }
}
