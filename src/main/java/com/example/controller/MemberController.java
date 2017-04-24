package com.example.controller;

import com.example.model.Member;
import com.example.repository.MemberRepository;
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
public class MemberController {
    @Autowired
    MemberRepository memberRepository;

    @RequestMapping("/members")
    public ResponseEntity<Member> findAllApi(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("result", memberRepository.findAll());

        return new ResponseEntity(result, HttpStatus.OK);
    }
}
